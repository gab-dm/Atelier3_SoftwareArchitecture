package DTOs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



public class UserDto {
	
	private Integer id;
	private float solde;
	private List<CardDto> CardList;
	
		public UserDto() {
			this.CardList=new ArrayList<CardDto>();
		}
		
		
		public UserDto (Integer _id , float _solde, List<CardDto> _cardList) {
			
			super();
			this.id = _id;
			this.solde = _solde;
			
			this.CardList = _cardList;
			
		}
	
		public Integer getId() {
			return id;
		}
	
		public void setId(Integer id) {
			this.id = id;
		}
	
		
		
		@Override
		public String toString() {
			return "id :"+ this.id+ " Solde : " + this.solde + " deck : "+ this.CardList;
		}
	
		public List<CardDto> getCardList() {
			return CardList;
		}
	
		public void setCardList(List<CardDto> cardList) {
			CardList = cardList;
		}
	
		
	
		public float getSolde() {
			return solde;
		}
	
		public void setSolde(float solde) {
			this.solde = solde;
		}
		
		//public String buyCard(Card card, int price) {
	
		public void addCard(CardDto card) {
			// TODO Auto-generated method stub
			this.CardList.add(card);
		}
	
		public void removeCard(CardDto card) {
			// TODO Auto-generated method stub
			this.CardList.remove(card);
		}
			
			
		
	
	}
