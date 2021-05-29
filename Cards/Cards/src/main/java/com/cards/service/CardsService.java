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
	
	public List<Cards> generateCardList(){
		Random random = new Random(System.currentTimeMillis()); //Pour avoir une seed "unique", on utilise la date
		
		List<Cards> cards = new ArrayList<>();
		List<Cards> cardsAvailable = cRepository.findAll();
        int nbCardsAvailable = cardsAvailable.size();
        Cards randomCard;
        while(cards.size()<5){
        	
        	int randomNumber =random.nextInt(nbCardsAvailable);
            randomCard = cardsAvailable.get(randomNumber);
            if (randomCard.getIsFree()) {
            	randomCard.setNotFree();
            	cards.add(randomCard);
            	
            }
            
        }
        return cards;
	}

	
}