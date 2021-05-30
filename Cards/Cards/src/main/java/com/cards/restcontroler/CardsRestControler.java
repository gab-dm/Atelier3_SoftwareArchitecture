package com.cards.restcontroler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cards.model.Cards;
import com.cards.service.CardsService;

import DTOs.MarketCardDTO;


@RestController
@RequestMapping("/cards")
public class CardsRestControler {
    @Autowired
    CardsService cService;
    
    @RequestMapping(method=RequestMethod.POST,value="/card")
    public void addCard(@RequestBody Cards card) {
        cService.addCard(card);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/GetCard/{id}")
    public Cards getCard(@PathVariable String id) {
        Cards c = cService.getCard(Integer.valueOf(id));
        return c;
    }
    
   
    
    @RequestMapping(method=RequestMethod.POST,value="/SetCardUserId")
    public void SetUserId(@PathVariable MarketCardDTO cardDTO){
    	Cards c = cService.getCard(cardDTO.getId());
    	c.setIdJoueur(cardDTO.getIdJoueur());
    	cService.Save(c);
    	
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/addDeck/{userId}")
    public void CreateDeck(@PathVariable Integer userId){
    	
    	cService.generateCardList(userId);
    	return ;
    	
    }


}
