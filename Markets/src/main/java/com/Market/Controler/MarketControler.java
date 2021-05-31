package com.Controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.DTOs.CardDto;
import com.DTOs.UserDto;

import com.Model.Market;
import com.Repository.MarketRepository;
import com.Service.MarketService;



@RestController
@RequestMapping("/market")

public class MarketControler {
	@Autowired
	MarketRepository mRepository;
	
	@Autowired
	MarketService mService;
    
    @RequestMapping(method=RequestMethod.POST,value="/test")
    public void addCard() {
        System.out.println("okokokokok");
    }
	
	
    @GetMapping("/test")
    public String test() {
        return "hello";
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
