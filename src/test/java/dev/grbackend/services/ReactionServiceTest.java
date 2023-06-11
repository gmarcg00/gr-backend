package dev.grbackend.services;

import dev.grbackend.models.Reaction;
import dev.grbackend.repositories.ReactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;

public class ReactionServiceTest {
    static ReactionService reactionService;
    static ReactionRepository reactionRepository;

    @BeforeAll
    static void setUp(){
        reactionService = new ReactionService();
        reactionRepository = PowerMockito.mock(ReactionRepository.class);
        Whitebox.setInternalState(reactionService,"reactionRepository",reactionRepository);
    }

    @Test
    void saveReactionTest(){
        Reaction reaction = new Reaction();
        Mockito.when(reactionRepository.save(reaction)).thenReturn(reaction);
        var response = reactionService.saveReaction(reaction);
        Assertions.assertEquals(reaction,response);
    }

    @Test
    void getReactionTest(){
        List<Reaction> reactionList = new ArrayList<>();
        Reaction reaction = new Reaction("user1","GTA V","Like");
        reactionList.add(reaction);
        Mockito.when(reactionRepository.findByUserName("user1")).thenReturn(reactionList);
        var response = reactionService.getReaction("user1","GTA V");
        Assertions.assertEquals(reaction,response);
    }

    @Test
    void getGameLikeReactions(){
        List<Reaction> reactionList = new ArrayList<>();
        Reaction reaction = new Reaction("user1","GTA V","Like");
        reactionList.add(reaction);
        Mockito.when(reactionRepository.findBySlug("GTA V")).thenReturn(reactionList);
        var response = reactionService.getGameLikeReactions("GTA V");
        Assertions.assertEquals(reactionList,response);
    }

    @Test
    void deleteReactionTest(){
        List<Reaction> reactionList = new ArrayList<>();
        Reaction reaction = new Reaction(Long.parseLong("1"),"user1","GTA V","Like");
        reactionList.add(reaction);
        Mockito.when(reactionRepository.findByUserName("user1")).thenReturn(reactionList);
        Assertions.assertTrue(reactionService.deleteReaction(reaction));
    }
}
