package dev.grbackend.services;

import dev.grbackend.models.Game;
import dev.grbackend.repositories.GameRepository;
import dev.grbackend.request.model.GamesRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    GamesRequest gamesRequest;

    public ArrayList<Game> filterGames(){
        return (ArrayList<Game>) gameRepository.findAll();
    }

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    public List<Game> filterGames(String genre, String platform, String store){
        List<Game> result = new ArrayList<>();

        result = gamesRequest.getGames();

        if(!genre.equals("null")) result = filterByGenre(result,genre);
        if(!platform.equals("null")) result = filterByPlatform(result,platform);
        if(!store.equals("null")) result = filterByStore(result,store);

        return result;
    }

    private List<Game> filterByGenre(List<Game> listGames, String genre){
        return listGames.stream()
                .filter(x -> x.containsGenre(genre))
                .collect(Collectors.toList());
    }

    private List<Game> filterByPlatform(List<Game> listGames, String platform){
        return listGames.stream()
                .filter(x -> x.containsPlatform(platform))
                .collect(Collectors.toList());
    }

    private List<Game> filterByStore(List<Game> listGames, String store){
        return listGames.stream()
                .filter(x -> x.containsStore(store))
                .collect(Collectors.toList());
    }

}
