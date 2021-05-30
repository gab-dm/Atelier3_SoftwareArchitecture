package com.card.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.card.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

    public Optional<Card> findById(int id);
    public List<Card> findAll();
}
