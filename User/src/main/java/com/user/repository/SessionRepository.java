package com.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.user.model.Session;


public interface SessionRepository extends CrudRepository<Session, Integer> {

	public  Optional<Session> findByTokenAndIp(String Token, String Ip);
	public  Optional<Session> findByIdUser(Integer id);
	public Optional<Session> findByToken(String token);

}
