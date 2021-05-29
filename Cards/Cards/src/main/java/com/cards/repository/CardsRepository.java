package com.cards.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cards.model.Cards;

public interface CardsRepository extends CrudRepository<Cards, Integer> {
	
	public Optional<Cards> findById(int id);
	public List<Cards> findAll();
}
