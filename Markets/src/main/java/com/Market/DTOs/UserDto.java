package com.DTOs;



public class UserDto {
	
	private Integer id;
	private float solde;
	

	
		public Integer getId() {
			return id;
		}
	
		public void setId(Integer id) {
			this.id = id;
		}
	
		
		
		@Override
		public String toString() {
			return "id :"+ this.id+ " Solde : " + this.solde;
		}
	
		
	
		public float getSolde() {
			return solde;
		}
	
		public void setSolde(float solde) {
			this.solde = solde;
		}
		
		
	
	}
