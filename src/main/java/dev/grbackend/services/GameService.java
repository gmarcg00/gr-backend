package dev.grbackend.services;

import dev.grbackend.models.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import static dev.grbackend.utils.Helper.getRegexFromPrefix;

@Service
public class GameService {
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

    public List<Game> findGames(String genre, String platform, String store){
        GameMemory resultFilter = new GameMemory();
        resultFilter.setList(gameMemory.getList());

        if(!genre.equals("null")) resultFilter.setList(resultFilter.findByGenre(genre));
        if(!platform.equals("null")) resultFilter.setList(resultFilter.findByPlatform(platform));
        if(!store.equals("null")) resultFilter.setList(resultFilter.findByStore(store));

        return resultFilter.getList();
    }

    public List<Game> searchByPrefix (String prefix){
        List<Game> result = gameMemory.searchByPrefix(getRegexFromPrefix(prefix));

        if (result.size() >= 6) return result.subList(0,5);
        else return result;
    }


}
