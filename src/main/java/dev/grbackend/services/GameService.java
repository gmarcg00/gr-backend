package dev.grbackend.services;

import dev.grbackend.models.Game;
import dev.grbackend.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    GameMemory gameMemory;

    public ArrayList<Game> filterGames(){
        return (ArrayList<Game>) gameRepository.findAll();
    }

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    public List<Game> filterGames(String genre, String platform, String store){
        List<Game> result = new ArrayList<>();

        if(!genre.equals("null")) result = gameMemory.findByGenre(genre);
        if(!platform.equals("null")) result = gameMemory.findByPlatform(platform);
        if(!store.equals("null")) result = gameMemory.findByStore(store);

        return result;
    }
}
