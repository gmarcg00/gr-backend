package dev.grbackend.controllers;

import dev.grbackend.models.Game;
import dev.grbackend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> listGames = gameService.getAllGames();
        if(listGames != null){
            return new ResponseEntity<>(listGames, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("{slug}")
    public ResponseEntity<Game> getGame(@PathVariable("slug") String gameName){
        Game game = gameService.getGame(gameName);
        if(game != null){
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/genre/{genre}/platform/{plat}/store/{store}")
    public ResponseEntity<List<Game>> getGamesByGenre(@PathVariable("genre") String genre, @PathVariable("plat") String platform, @PathVariable("store") String store){
        List<Game> listGames = gameService.findGames(genre,platform,store);
        if(listGames != null){
            return new ResponseEntity<>(listGames, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @PostMapping()
    public Game saveGame(@RequestBody Game game){
        return this.gameService.saveGame(game);
    }
}
