package com.market.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.market.model.Market;



public interface MarketRepository extends CrudRepository<Market, Integer>{
	
	public List<Market> findAll();
	public Optional<Market> findById(Integer id);
}
