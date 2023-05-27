package dev.grbackend.services;

import dev.grbackend.models.Game;
import dev.grbackend.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import static dev.grbackend.utils.Helper.getRegexFromPrefix;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    GameMemory gameMemory;

    public List<Game> getAllGames(){
        return gameMemory.getList();
    }

    public Game getGame(String gameName){
        List<Game> list = gameMemory.findByName(gameName);

        if(list.size() == 1) return list.get(0);

        return null;
    }

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    public List<Game> findGames(String genre, String platform, String store){
        List<Game> result = new ArrayList<>();

        if(!genre.equals("null")) result = gameMemory.findByGenre(genre);
        if(!platform.equals("null")) result = gameMemory.findByPlatform(platform);
        if(!store.equals("null")) result = gameMemory.findByStore(store);

        return result;
    }

    public List<Game> searchByPrefix (String prefix){
        List<Game> result = gameMemory.searchByPrefix(getRegexFromPrefix(prefix));

        if (result.size() >= 6) return result.subList(0,5);
        else return result;
    }


}
