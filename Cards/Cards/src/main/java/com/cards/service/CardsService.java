package com.cards.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cards.model.Cards;
import com.cards.repository.CardsRepository;


@Service
public class CardsService {
	
	@Autowired
	
	CardsRepository cRepository;
	
	
	public void addCard(Cards c) {
		Cards createdCard=cRepository.save(c);
		System.out.println(createdCard);
	}
	
	public Cards getCard(int id) {
		Optional<Cards> cOpt =cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}
	
	//pour ajouter des cartes à un utilisateur, on a chagé notre méthode et maintenant on ajoute un utilisateur à nos cartes
	public List<Cards> generateCardList(Integer _idJoueur){
		Random random = new Random(System.currentTimeMillis()); //Pour avoir une seed "unique", on utilise la date
		
		List<Cards> cards = new ArrayList<>();
		List<Cards> cardsAvailable = cRepository.findAll();
        int nbCardsAvailable = cardsAvailable.size();
        Cards randomCard;
        while(cards.size()<3){
        	
        	
        	//
        	int randomNumber =random.nextInt(nbCardsAvailable);
            randomCard = cardsAvailable.get(randomNumber);
            if (randomCard.getIsFree()) { // les cartes qui n'ont pas encore d'utilisateur on un tag spécial
            	randomCard.setNotFree();
            	randomCard.setIdJoueur(_idJoueur);
            	
            	cards.add(randomCard);
            	this.Save(randomCard);
            	
            	System.out.println("carte ajoutée au joueur id : "+_idJoueur+" carte : "+randomCard);
            }
            
        }
        return cards;
	}
	
	 public void Save (Cards c ) {
	        cRepository.save(c);
	 }

	
}
