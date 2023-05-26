package dev.grbackend.process;

import dev.grbackend.models.Game;
import dev.grbackend.request.model.GameRequest;
import dev.grbackend.services.GameMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadData {
    @Autowired
    GameRequest gamesRequest;
    @Autowired
    GameMemory gameMemory;

    public void loadGamesData(){
        List<Game> listGame = gamesRequest.getData();
        gameMemory.setList(listGame);
    }
}
