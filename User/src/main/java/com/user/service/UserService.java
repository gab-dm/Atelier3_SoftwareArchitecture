package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.user.model.User;
import com.user.repository.UserRepository;



@Service
public class UserService {
	
	static final String URL_CARDLIST = "http://localhost:8081/cardlist";

	
	@Autowired
	UserRepository uRepository;
	
	/*public CardDto[] listCards(){
		RestTemplate restTemplate = new RestTemplate();
		 // Send request with GET method and default Headers.
	    CardDto[] list = restTemplate.getForObject(URL_CARDS, CardDto[].class);

	    if (list != null) {
	        for (CardDto e : list) {
	            System.out.println("Card: " + e.getId() + " - " + e.getName());
	        }
	    }
	    return list;
	}*/
	
	public boolean addUser(User u) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CardDto[]> response = restTemplate.getForEntity(URL_CARDLIST, CardDto[].class);
		CardDto[] listCards = response.getBody();
		
		//System.out.println(uRepository.findByName(u.getName()));
		if(!uRepository.findByName(u.getName()).isPresent()) {
			u.setCardList(listCards);
			User createdUser=uRepository.save(u);
			System.out.println(createdUser);
			return true;
		}
		else {
			return false;
		}
	}

	
	public User getUserById(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	
	public User getUserByName(String  Name) {
		Optional<User> uOpt =uRepository.findByName(Name);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	
	public void UpdateUser (User u ) {
		uRepository.save(u);
	}
	
	//On supprime l'utilisateur depuis son ID.
	public void DeleteUserByID (Integer integer) {
		uRepository.deleteById(integer);
		return ;
		
	}
	//On supprime l'utilisateur depuis son Nom.
	public void DeleteUserByName (String name ) {
		User user =uRepository.findByName(name).get();
		uRepository.deleteById(user.getId());
		return;
		
	}
	
	 
   

	 public static class CardDto {
		 private Integer id;
		 private String name;
		 private static Integer price;
		 private boolean isFree = true;

		 
		 public CardDto(){
			 
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
		
		public void setPrice(Integer price) {
			CardDto.price = price;
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
		 
	 }
}




