package dev.grbackend.services;


import dev.grbackend.models.Reaction;
import dev.grbackend.repositories.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReactionService {
    @Autowired
    ReactionRepository reactionRepository;

    public Reaction saveReaction (Reaction reaction){
        return reactionRepository.save(reaction);
    }

    public Reaction getReaction(String userName, String slug){
        List<Reaction> userReactions = reactionRepository.findByUserName(userName);
        userReactions = userReactions.stream().
                filter(x -> x.getSlug().equals(slug))
                .collect(Collectors.toList());
        if(userReactions.isEmpty()) return null;
        else return userReactions.get(0);
    }

    public List<Reaction> getGameLikeReactions (String slug){
        List<Reaction> reactionList = reactionRepository.findBySlug(slug);
        return reactionList.stream()
                .filter(x -> x.getReactionType().equals("Like"))
                .collect(Collectors.toList());
    }

    public boolean deleteReaction (Reaction reaction){
        reaction = getReaction(reaction.getUserName(), reaction.getSlug());
        try {
            reactionRepository.deleteById(reaction.getId());
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
