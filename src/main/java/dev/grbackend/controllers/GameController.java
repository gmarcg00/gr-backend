package dev.grbackend.controllers;

import dev.grbackend.models.Game;
import dev.grbackend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping
    public ResponseEntity<ArrayList<Game>> getGames(){
        ArrayList<Game> listGames = gameService.getGames();
        if(listGames != null){
            return new ResponseEntity<>(listGames, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
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
