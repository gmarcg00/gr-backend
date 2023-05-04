package dev.grbackend.services;

import dev.grbackend.models.Game;
import dev.grbackend.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    public ResponseEntity<Iterable<Game>> getGames(){
        return new ResponseEntity<>(gameRepository.findAll(), HttpStatus.OK);
        /*
        String url = "https://api.rawg.io/api/games/the-last-of-us?key=66d0c7fd878844b6b062fe3f3822a772";
        HttpHeaders headers = new HttpHeaders();

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Game> response = restTemplate.exchange(url, HttpMethod.GET,request, Game.class);
        Game game = response.getBody();
        if(game!=null){
            gameRepository.save(game);
        }
        return null;
         */
    }

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }
}
