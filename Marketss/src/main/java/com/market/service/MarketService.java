package com.market.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.DTOs.CardDto;
import com.DTOs.UserDto;

import com.market.model.Market;
import com.market.repository.MarketRepository;


@Service
public class MarketService {
	
	@Autowired	
	MarketRepository mRepository;
	
	
	public List<Market> getAllMarket() {
		
		List<Market> MarketList = mRepository.findAll();
		return MarketList;
	}
	
	public String buyACard (UserDto buyer, CardDto card, Market market) {
		
		UserDto seller = this.getUserById(market.getUserId());
		System.out.println("buyer :"+buyer);
		System.out.println("card :"+card);
		if (buyer.getSolde()< card.getPrice()) {
					
					
			return "Pas assez d'argent";
		
		}
		else {
			buyer.setSolde(buyer.getSolde()-card.getPrice());
			
			//désuet avec la nouvelle methode
			//buyer.addCard(card);
			
			this.PostUserSold(buyer);
			
			
			seller.setSolde(seller.getSolde()+card.getPrice());
			
			//désuet avec la nouvelle methode
			//seller.removeCard(card);
			
			this.PostUserSold(seller);
			
			//méthode pour changer l'ID de l'utilisateur a qui appartient la carte à récup quand Thomas/Lucas l'aura implémentée
			card.setIdJoueur(buyer.getId());
			
			this.PostCard(card);
			
			mRepository.delete(market);
			return "transaction effectuee";
		}
		
	}
	
	public String sellACard(UserDto seller, CardDto card) {
		//on suppose dans cette partie qu'un utilisateur n'a pas pu envoyer une requete de mise en vente sur une carte qu'il ne possède pas
		 
		List<Market> MarketList = this.getAllMarket();
		boolean carteEnVente = false;
		
		for (Market market : MarketList) {
			
			if ((market.getCardId() == card.getId()) && market.getUserId()==seller.getId() ) {
				carteEnVente =true;
			}
		}
		if (!carteEnVente) {
			Market newMarket = new Market(card.getId(), seller.getId());
			System.out.println("MArket id :"+newMarket.getMarketId());
			this.addMarket(newMarket);
			System.out.println("MArket id :"+newMarket.getMarketId());
			return "carte mise en vente";
			
			
		}
		else {
			return "la carte est déja en vente";
		}
		
	}
	public void addMarket(Market m) {
		Market createdMarket=mRepository.save(m);
		System.out.println(createdMarket.toString());
	}

	public UserDto getUserBySession(String token, HttpServletRequest request) {
		String UrlGetUserBySession = "http://127.0.0.1:8082/user/getUserByToken/"+token;
		UserDto user = new RestTemplate().getForObject(UrlGetUserBySession,UserDto.class);
		return user;
	}
	public UserDto getUserById(Integer UserId) {
		String UrlGetUserById = "http://127.0.0.1:8082/user/getUserId/"+UserId;
		UserDto user = new RestTemplate().getForObject(UrlGetUserById,UserDto.class);
		return user;
	}

	public CardDto getCardById(Integer cardId) {
		String UrlGetcardById = "http://127.0.0.1:8081/cards/GetCard/"+cardId;
		CardDto card = new RestTemplate().getForObject(UrlGetcardById,CardDto.class);
		return card;
	}
	
	public void PostCard(CardDto _card) {
		String UrlPostCardInDeck = "http://127.0.0.1:8081/cards/SetCardUserId";
		new RestTemplate().postForObject(UrlPostCardInDeck, _card, Object.class);
	}
	
	public void PostUserSold(UserDto _user) {
		String UrlPostUserSold ="http://127.0.0.1:8082/user/SetUserSold";
		new RestTemplate().postForObject(UrlPostUserSold, _user, Object.class);
	}
	
}
