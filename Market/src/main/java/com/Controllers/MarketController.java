package com.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import DTOs.CardDto;
import DTOs.UserDto;
import Models.Market;
import Repositories.MarketRepository;
import Services.MarketService;



@RestController
@RequestMapping("/market")

public class MarketController {
	@Autowired
	MarketRepository mRepository;
	
	@Autowired
	MarketService mService;
    
    @RequestMapping(method=RequestMethod.POST,value="/test")
    public void addCard() {
        System.out.println("okokokokok");
    }
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/buy") 
	public String BuyCard(Integer marketId, String token, Integer cardId,HttpServletResponse response,HttpServletRequest request) {
	  
		UserDto buyer = mService.getUserBySession(token, request); 
		
		CardDto card = mService.getCardById(cardId);
		Market market = mRepository.findById(marketId).orElseThrow(() -> new RuntimeException("Pas de market"));;
		System.out.println("this market id is :"+market.getMarketId()); 
		return mService.buyACard(buyer, card, market);
		  
	  
	}
	 
	@RequestMapping(method=RequestMethod.POST,value="/sell")
	public String SellCard(@PathVariable String token,  @PathVariable Integer cardId, HttpServletResponse response,HttpServletRequest request) {
	    
		System.out.println("token :"+token) ;  
	    
	    System.out.println("cardId :"+cardId) ; 
	    
	    System.out.println("request :"+request) ; 
	    
		UserDto seller = mService.getUserBySession(token , request);
	 	
	 	CardDto card = mService.getCardById(cardId);
	 	
	 	return mService.sellACard(seller, card);
		
	 	
    }
}
