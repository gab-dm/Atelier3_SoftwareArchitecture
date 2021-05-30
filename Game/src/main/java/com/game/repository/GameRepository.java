package com.game.repository;

import com.game.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    public Game findById(int id);

    public Game findByRoomId(int roomId);

    public List<Game> findAll();

}
