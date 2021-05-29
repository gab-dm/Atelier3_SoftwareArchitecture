package com.cards.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.user.model.Card;
import com.user.model.Cards;


@Entity(name="Cards")
public final class Cards {


@Id
@GeneratedValue
private Integer id;
private String name;
private Integer hp;
private String description;
private String imgUrl;
private Integer attack;
private Integer defence;
private boolean isFree = true;
private List<Cards> CardList;


@ManyToMany

private static Integer price;
	
	public Cards() {}


	public Cards( String name , Integer hp, String description, String imgUrl, Integer attack, Integer defence, Integer price ) {
		
		super();
		this.name = name;
		this.hp = hp;
		this.description = description ;
		this.imgUrl = imgUrl; 
		this.attack = attack;
		this.defence = defence;
		
		Cards.price = price;
		
		this.CardList=new ArrayList<Cards>();
		
	}

public Cards( String name , Integer hp, String description, String imgUrl, Integer attack, Integer defence ) {
		
		super();
		this.name = name;
		this.hp = hp;
		this.description = description ;
		this.imgUrl = imgUrl; 
		this.attack = attack;
		this.defence = defence;
		
		Cards.price = 500;
		this.CardList=new ArrayList<Cards>();
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	
	public Integer getAttack() {
		return attack;
	}
	
	public void setDefence(Integer defence) {
		this.defence = defence;
	}
	
	public Integer getDefence() {
		return defence;
	}
	
	
	public void setPrice(Integer price) {
		Cards.price = price;
	}
	
	public static Integer getPrice() {
		return price;
	}
	public boolean getIsFree() {
		return this.isFree;
	}
	public void setNotFree() {
		this.isFree = false;
	}
	

	public List<Cards> getCardList() {
		return CardList;
	}

	public void setCardList(List<Cards> cardList) {
		CardList = cardList;
	}
	
	//public String buyCard(Card card, int price) {

	public void addCard(Cards card) {
		// TODO Auto-generated method stub
		this.CardList.add(card);
	}

	public void removeCard(Cards card) {
		// TODO Auto-generated method stub
		this.CardList.remove(card);
	}
	
	@Override
	public String toString() {
		return "Carte ["+getId()+"]: name:"+getName() +", hp:"+getHp()+", imgUrl:"+getImgUrl() + ", attack:"+getAttack() + ", defence:" +getDefence();
	}
	

} 