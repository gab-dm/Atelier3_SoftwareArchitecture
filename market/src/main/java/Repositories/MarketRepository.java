package Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import Models.Market;



public interface MarketRepository extends CrudRepository<Market, Integer>{
	
	public List<Market> findAll();
	public Optional<Market> findById(Integer id);
}
