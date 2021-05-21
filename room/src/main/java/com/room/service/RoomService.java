package com.room.service;

import java.util.List;

public class RoomService<CardDTO> {


public  RoomService() {}
		 
	public void combat() {
			
		
		
	}
	
	public void getUserId() {
		
	}
	
	public CardDTO getCard(Integer _cardId) {
		String Request = "/localhost:808X/card/"+_cardId;
		CardDTO card = new RestTemplate.getforObject(Request, CardDTO.class);
		
		
	}
}
	

