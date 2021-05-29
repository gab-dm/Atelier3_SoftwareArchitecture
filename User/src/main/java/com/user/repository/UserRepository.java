package com.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.user.model.User;

public interface UserRepository extends
CrudRepository<User, Integer> {
	Optional<User> EMPTY = null;
	public Optional<User> findById(int id);
	public Optional<User> findByName(String name);
	

}
