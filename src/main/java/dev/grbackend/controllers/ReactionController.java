package dev.grbackend.controllers;

import dev.grbackend.models.Reaction;
import dev.grbackend.services.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reaction")
@CrossOrigin(origins = "http://localhost:3000")
public class ReactionController {
    @Autowired
    private ReactionService reactionService;
    @PostMapping()
    public ResponseEntity<Reaction> saveReaction (@RequestBody Reaction reaction){
       Reaction newReaction =  reactionService.saveReaction(reaction);
        if(newReaction != null){
            return new ResponseEntity<>(newReaction, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/user/{userName}/game/{slug}")
    public ResponseEntity<Reaction> getReaction (@PathVariable("userName") String userName, @PathVariable("slug") String slug){
        Reaction reaction = reactionService.getReaction(userName,slug);
        if(reaction != null){
            return new ResponseEntity<>(reaction, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("like/game/{slug}")
    public ResponseEntity<List<Reaction>> getGameLikeReactions (@PathVariable("slug") String slug){
        List<Reaction> reactionList = reactionService.getGameLikeReactions(slug);
        if(reactionList != null){
            return new ResponseEntity<>(reactionList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteReaction (@RequestBody Reaction reaction){
        if(reactionService.deleteReaction(reaction)) return new ResponseEntity<>(HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
