package dev.grbackend.services;

import dev.grbackend.models.Game;
import dev.grbackend.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    public ArrayList<Game> getGames(){
        return (ArrayList<Game>) gameRepository.findAll();
    }

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }
}
