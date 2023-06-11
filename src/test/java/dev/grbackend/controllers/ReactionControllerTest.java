package dev.grbackend.controllers;


import dev.grbackend.models.Reaction;
import dev.grbackend.services.ReactionService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

class ReactionControllerTest {
    static ReactionController reactionController;
    static ReactionService reactionService;

    @BeforeAll
    static void setup(){
        reactionController = new ReactionController();
        reactionService = PowerMockito.mock(ReactionService.class);
        Whitebox.setInternalState(reactionController,"reactionService",reactionService);
    }

    @Test
    void saveReactionTest(){
        Reaction reaction = new Reaction();
        Mockito.when(reactionService.saveReaction(reaction)).thenReturn(reaction);
        var response = reactionController.saveReaction(reaction);
        Assert.assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    @Test
    void getReactionTest(){
        Reaction reaction = new Reaction();
        Mockito.when(reactionService.getReaction("user1","GTA V")).thenReturn(reaction);
        var response = reactionController.getReaction("user1","GTA V");
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
        Mockito.when(reactionService.getReaction("user2","GTA IV")).thenReturn(null);
        response = reactionController.getReaction("user2","GTA IV");
        Assert.assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
    }

    @Test
    void getGameLikeReactionsTest(){
        List<Reaction> reactionList = new ArrayList<>();
        Reaction reaction = new Reaction();
        reactionList.add(reaction);
        Mockito.when(reactionService.getGameLikeReactions("Overcooked II")).thenReturn(reactionList);
        var response = reactionController.getGameLikeReactions("Overcooked II");
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
        reactionList.clear();
        Mockito.when(reactionService.getGameLikeReactions("GTA San Andreas")).thenReturn(reactionList);
        response = reactionController.getGameLikeReactions("GTA San Andreas");
        Assert.assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
    }

    @Test
    void deleteReactionTest(){
        Reaction reaction = new Reaction();
        Mockito.when(reactionService.deleteReaction(reaction)).thenReturn(true);
        var response = reactionController.deleteReaction(reaction);
        Assertions.assertEquals(HttpStatus.CREATED,response.getStatusCode());
        Mockito.when(reactionService.deleteReaction(reaction)).thenReturn(false);
        response = reactionController.deleteReaction(reaction);
        Assertions.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
}
