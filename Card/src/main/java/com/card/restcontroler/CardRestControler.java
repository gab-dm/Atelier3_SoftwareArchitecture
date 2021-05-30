package com.card.restcontroler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.card.model.Card;
import com.card.service.CardService;


@RestController
public class CardRestControler {
    @Autowired
    CardService cService;

    @RequestMapping(method=RequestMethod.POST,value="/card")
    public void addCard(@RequestBody Card card) {
        cService.addCard(card);
    }

    @RequestMapping(method=RequestMethod.GET,value="/card/{id}")
    public Card getCard(@PathVariable String id) {
        Card c = cService.getCard(Integer.valueOf(id));
        return c;
    }

    @RequestMapping(method=RequestMethod.POST,value="/cardlist")
    public List<Card> generateCardList(){
        List<Card> cardlist= cService.setCardList(generateCardList());
        return cardlist;
    }


}