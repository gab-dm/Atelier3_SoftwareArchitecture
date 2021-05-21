package Services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import DTOs.CardDto;
import Models.Market;
import DTOs.UserDto;
import Repositories.MarketRepository;


@Service
public class MarketService {
	
	@Autowired	
	MarketRepository mRepository;
	
	
	public List<Market> getAllMarket() {
		
		List<Market> MarketList = mRepository.findAll();
		return MarketList;
	}
	
	public String buyACard (UserDto buyer, UserDto seller, CardDto card, Market market) {
		
		if (buyer.getSolde()<DTOs.CardDto.getPrice()) {
					
					
			return "Pas assez d'argent";
		
		}
		else {
			buyer.setSolde(buyer.getSolde()-CardDto.getPrice());
			buyer.addCard(card);
			uService.UpdateUser(buyer);
			
			seller.setSolde(seller.getSolde()+CardDto.getPrice());
			seller.removeCard(card);
			uService.UpdateUser(seller);
			
			mRepository.delete(market);
			return "transaction effectuee";
		}
		
	}
	
	public String sellACard(UserDto seller, CardDto card) {
		
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
		String UrlGetUserBySession = "";
		UserDto user = new RestTemplate().getForObject(UrlGetUserBySession,UserDto.class);
		return user;
	}

	public CardDto getCardById(Integer cardId) {
		String UrlGetcardById = "";
		CardDto card = new RestTemplate().getForObject(UrlGetcardById,CardDto.class);
		return card;
	}
	
	public void PostCardInDeck(CardDto _card, UserDto _user) {
		String UrlPostCardInDeck = "";
		new RestTemplate().postForObject(UrlPostCardInDeck, _card, null);
	}
	
	
}
