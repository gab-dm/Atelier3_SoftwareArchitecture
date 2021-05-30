package com.room.model;

@Entity(name="Room")

public class Room {
	
	@Id
	@GeneratedValue
    private Integer id;
	private String name;
	private String owner;
	private int bet;
	private String challenger;
	private String cardOwner;
	private String cardChallenger;

	public Room() {
	}
	
	public Room( String name,String owner, int bet) {
		this.name = name;
		this.setOwner(owner);
		this.setBet(bet);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}


	public String getChallenger() {
		return challenger;
	}

	public void setChallenger(String challenger) {
		this.challenger = challenger;
	}
	
	
	public String getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}

	public String getCardChallenger() {
		return cardChallenger;
	}

	public void setCardChallenger(String cardChallenger) {
		this.cardChallenger = cardChallenger;
	}
	
	@Override
	public String toString() {
		return "Room ["+this.id+"]: :"+this.name+", bet:"+this.bet+", owner:"+this.owner+", challenger:"+this.challenger +", owner's card:"+ this.cardOwner +", challenger's card:"+ this.cardChallenger;
	}

}