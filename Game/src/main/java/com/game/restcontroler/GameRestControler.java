package com.game.restcontroler;

import com.game.model.Game;
import com.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameRestControler {
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/all")
    private List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PutMapping(value="/{gameId}")
    public void updateGame(@PathVariable int gameId, @RequestBody Game game) {
        game.setId(gameId);
        gameService.updateGame(game);
    }

    @DeleteMapping(value="/{id}")
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }

}
