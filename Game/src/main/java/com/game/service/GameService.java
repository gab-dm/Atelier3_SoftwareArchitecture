package com.game.service;

import com.game.model.Game;
import com.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;


    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGame(int id) {
        return gameRepository.findById(id);
    }

    public void updateGame(Game game) {
        gameRepository.save(game);
    }

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

}