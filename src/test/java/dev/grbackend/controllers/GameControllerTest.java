package dev.grbackend.controllers;

import dev.grbackend.models.Game;
import dev.grbackend.services.GameService;
import dev.grbackend.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class GameControllerTest {
    static GameController gameController;
    static GameService gameService;

    @BeforeAll
    static void setup(){
        gameController = new GameController();
        gameService = PowerMockito.mock(GameService.class);
        Whitebox.setInternalState(gameController,"gameService",gameService);
    }
    @Test
    void getAllGamesTest(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        gameList.add(game);
        Mockito.when(gameService.getAllGames()).thenReturn(gameList);
        var response = gameController.getAllGames();
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Mockito.when(gameService.getAllGames()).thenReturn(null);
        response = gameController.getAllGames();
        Assertions.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    void getGameTest(){
        Game game = new Game();
        Mockito.when(gameService.getGame("The Last Of Us II")).thenReturn(game);
        var response = gameController.getGame("The Last Of Us II");
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Mockito.when(gameService.getGame("xxxx")).thenReturn(null);
        response = gameController.getGame("xxxx");
        Assertions.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    void filterGamesTest(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        gameList.add(game);
        Mockito.when(gameService.findGames("action","playstation5","null")).thenReturn(gameList);
        var response = gameController.filterGames("action","playstation5","null");
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(1,response.getBody().size());
        gameList.clear();
        Mockito.when(gameService.findGames("action","playstation3","null")).thenReturn(gameList);
        response = gameController.filterGames("action","playstation3","null");
        Assertions.assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
        Assertions.assertFalse(response.hasBody());
    }

    @Test
    void searchByPrefix(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        gameList.add(game);
        Mockito.when(gameService.searchByPrefix("red")).thenReturn(gameList);
        var response = gameController.searchByPrefix("red");
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        gameList.clear();
        Mockito.when(gameService.searchByPrefix("rrr")).thenReturn(gameList);
        response = gameController.searchByPrefix("rrr");
        Assertions.assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
        Assertions.assertFalse(response.hasBody());
    }

    @Test
    void getUserLikedGamesTest(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        gameList.add(game);
        Mockito.when(gameService.getUserLikedGames("user1")).thenReturn(gameList);
        var response = gameController.getUserLikedGames("user1");
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        gameList.clear();
        Mockito.when(gameService.getUserLikedGames("userXXX")).thenReturn(gameList);
        response = gameController.getUserLikedGames("user1XXX");
        Assertions.assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
        Assertions.assertFalse(response.hasBody());
    }

    @Test
    void getRandonmGameTest(){
        Game game = new Game();
        Mockito.when(gameService.getRandomGame()).thenReturn(game);
        var response = gameController.getRandomGame();
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
    }
}
