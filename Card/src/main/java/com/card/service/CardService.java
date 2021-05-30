package com.card.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.model.Card;
import com.card.repository.CardRepository;


@Service
public class CardService {

    @Autowired

    CardRepository cRepository;


    public void addCard(Card c) {
        Card createdCard=cRepository.save(c);
        System.out.println(createdCard);
    }

    public Card getCard(int id) {
        Optional<Card> cOpt =cRepository.findById(id);
        if (cOpt.isPresent()) {
            return cOpt.get();
        }else {
            return null;
        }
    }

    public List<Card> setCardList(List<Card> cardList) {
        List<Card> CardList;
        CardList = cardList;
        return CardList;
    }


    public List<Card> generateCardList(){
        Random random = new Random(System.currentTimeMillis()); //Pour avoir une seed "unique", on utilise la date

        List<Card> cards = new ArrayList<>();
        List<Card> cardsAvailable = cRepository.findAll();
        int nbCardsAvailable = cardsAvailable.size();
        Card randomCard;
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