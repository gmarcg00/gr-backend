package dev.grbackend.services;

import dev.grbackend.models.Game;
import dev.grbackend.repositories.ReactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;

class GameServiceTest {
    static GameService gameService;
    static ReactionRepository reactionRepository;
    static GameMemory gameMemory;

    @BeforeAll
    static void setup(){
        gameService = new GameService();
        reactionRepository = PowerMockito.mock(ReactionRepository.class);
        gameMemory = PowerMockito.mock(GameMemory.class);
        Whitebox.setInternalState(gameService,"gameMemory",gameMemory);
        Whitebox.setInternalState(gameService,"reactionRepository",reactionRepository);
    }

    @Test
    void getAllGamesTest(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        gameList.add(game);
        Mockito.when(gameMemory.getList()).thenReturn(gameList);
        var response = gameService.getAllGames();
        Assertions.assertEquals(gameList,response);
    }

    @Test
    void getGameTest(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        gameList.add(game);
        Mockito.when(gameMemory.findByName("The Last Of Us II")).thenReturn(gameList);
        var response = gameService.getGame("The Last Of Us II");
        Assertions.assertEquals(game,response);
        gameList.clear();
        Mockito.when(gameMemory.findByName("FIFA 24")).thenReturn(gameList);
        response = gameService.getGame("FIFA 24");
        Assertions.assertNull(response);
    }

    @Test
    void findGames(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        gameList.add(game);
        Mockito.when(gameMemory.getList()).thenReturn(gameList);
        var response = gameService.findGames("","","");
        Assertions.assertEquals(0,response.size());
    }

    @Test
    void searchByPrefixTest(){
        List<Game> gameList = new ArrayList<>();
        for(int i = 0; i < 6; i++) gameList.add(new Game());
        Mockito.when(gameMemory.searchByPrefix("R.*")).thenReturn(gameList);
        var response = gameService.searchByPrefix("r");
        Assertions.assertEquals(5,response.size());
        gameList.clear();
        Mockito.when(gameMemory.searchByPrefix("X.*")).thenReturn(gameList);
        response = gameService.searchByPrefix("x");
        Assertions.assertEquals(0,response.size());
    }
}
