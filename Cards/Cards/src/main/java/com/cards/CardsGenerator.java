package com.cards;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cards.model.Cards;
import com.cards.service.CardsService;



@Component
public class CardsGenerator implements ApplicationRunner {
	@Autowired
	CardsService cService;
	public void run(ApplicationArguments args) throws Exception {
		Cards card = new Cards( "Pikachu" ,  100,  "Pika chuuuu!",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Cards( "tiplouf" ,  100,  "titiit!",  "url",  15,  15);
		cService.addCard(card);
		
		card = new Cards( "ratata" ,  100,  "ratatat!",  "url",  15,  10);
		cService.addCard(card);
		
		card = new Cards( "bulbizar" ,  100,  "bulbi bulbi!",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Cards( "dracaufeu" ,  100,  "draaa!",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Cards( "carapuce" ,  100,  "cara!",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Cards( "chenipan" ,  100,  "cheniii",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Cards( "florizar" ,  100,  "flori",  "url",  10,  10);
		cService.addCard(card);
	}
}
