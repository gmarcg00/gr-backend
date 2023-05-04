package dev.grbackend.controllers;

import dev.grbackend.models.Game;
import dev.grbackend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping
    public ResponseEntity<Iterable<Game>> getGames(){
        return gameService.getGames();
    }
    @RequestMapping(params = {"slug"})
    public ResponseEntity<Game> getGame (@RequestParam String slug){
        return null;
    }
    @PostMapping()
    public Game saveGame(@RequestBody Game game){
        return this.gameService.saveGame(game);
    }
}
