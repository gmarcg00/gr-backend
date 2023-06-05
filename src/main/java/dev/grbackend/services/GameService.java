package dev.grbackend.services;

import dev.grbackend.models.Game;

import dev.grbackend.models.Reaction;
import dev.grbackend.repositories.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dev.grbackend.utils.Helper.getRegexFromPrefix;

@Service
public class GameService {
    @Autowired
    GameMemory gameMemory;
    @Autowired
    ReactionRepository reactionRepository;


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

    public List<Game> getUserLikedGames(String userName){
        List<Reaction> reactionList = reactionRepository.findByUserName(userName);
        reactionList = reactionList.stream()
                .filter(x -> x.getReactionType().equals("Like"))
                .collect(Collectors.toList());
        List <Game> likeGameList = new ArrayList<>();
        for(Reaction reaction: reactionList){
            for (Game game : gameMemory.getList()){
                if(game.getSlug().equals(reaction.getSlug())){
                    likeGameList.add(game);
                    break;
                }
            }
        }
        return likeGameList;
    }


}
