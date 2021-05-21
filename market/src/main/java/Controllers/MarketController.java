package Controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import DTOs.CardDto;
import DTOs.UserDto;
import Repositories.MarketRepository;
import Services.MarketService;


@RestController
@RequestMapping("/market")
public class MarketController {

	
	@Autowired
	MarketRepository mRepository;
	
	@Autowired
	MarketService mService;
	
	
	
	/*
	 * @RequestMapping(method=RequestMethod.POST,value="/buy") public String
	 * BuyCard(Integer marketId, String token, Integer cardId, Integer sellerId,
	 * HttpServletResponse response,HttpServletRequest request) {
	 * 
	 * UserDto buyer = sessionService.isLogged(token , request); UserDto seller =
	 * uRepository.findById(sellerId) .orElseThrow(() -> new
	 * RuntimeException("Pas d'utilisateur")); Card card =
	 * cRepository.findById(cardId).orElseThrow(() -> new
	 * RuntimeException("Pas de carte trouvée avec cet id")); Market market =
	 * mRepository.findById(marketId).orElseThrow(() -> new
	 * RuntimeException("Pas de market"));;
	 * System.out.println("this market id is :"+market.getMarketId()); return
	 * mService.buyACard(buyer, seller, card, market);
	 * 
	 * 
	 * }
	 */
	@RequestMapping(method=RequestMethod.POST,value="/sell")
	public String SellCard(String token,  Integer cardId, HttpServletResponse response,HttpServletRequest request) {
	    
		System.out.println("token :"+token) ;  
	    
	    System.out.println("cardId :"+cardId) ; 
	    
	    System.out.println("request :"+request) ; 
	    
		UserDto seller = mService.getUserBySession(token , request);
	 	
	 	CardDto card = mService.getCardById(cardId);
	 	
	 	return mService.sellACard(seller, card);
		
	 	
    }
}
