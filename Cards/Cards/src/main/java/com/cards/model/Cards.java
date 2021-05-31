package com.cards.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;




@Entity(name="Cards")
public final class Cards {


@Id
@GeneratedValue
private Integer id;
private Integer idJoueur;
private String name;
private Integer hp;
private String description;
private String imgUrl;
private Integer attack;
private Integer defence;
private boolean isFree = true;

private Integer price =100;
	
	public Cards() {}


    public Cards( Integer idJoueur,String name , Integer hp, String description, String imgUrl, Integer attack, Integer defence ) {
		
		super();
	    this.idJoueur = idJoueur;
		this.name = name;
		this.hp = hp;
		this.description = description ;
		this.imgUrl = imgUrl; 
		this.attack = attack;
		this.defence = defence;
		
		
		
		
		
	}

    public Cards(String name , Integer hp, String description, String imgUrl, Integer attack, Integer defence ) {
		
		super();
	    this.idJoueur = -1;
		this.name = name;
		this.hp = hp;
		this.description = description ;
		this.imgUrl = imgUrl; 
		this.attack = attack;
		this.defence = defence;
		
		this.price = 100;
		
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdJoueur() {
        	return idJoueur;
    }

	public void setIdJoueur(Integer idJoueur) {
    	this.idJoueur = idJoueur;
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
		this.price = price;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	public boolean getIsFree() {
		return this.isFree;
	}
	public void setNotFree() {
		this.isFree = false;
	}
	

	@Override
	public String toString() {
		return "Carte ["+getId()+"]: name:"+getName() +" id Joueur : "+this.getIdJoueur()+", hp:"+getHp()+", imgUrl:"+getImgUrl() + ", attack:"+getAttack() + ", defence:" +getDefence();
	}
	

} 
