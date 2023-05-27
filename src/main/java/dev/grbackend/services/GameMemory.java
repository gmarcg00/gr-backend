package dev.grbackend.services;

import dev.grbackend.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameMemory {
    List<Game> list = new ArrayList<>();

    public List<Game> getList() {
        return list;
    }

    public void setList(List<Game> list) {
        this.list = list;
    }

    public Integer count(){return this.list.size();}

    public List<Game> findByName(String gameName){
        return list.stream()
                .filter(x -> x.getSlug().equals(gameName))
                .collect(Collectors.toList());
    }

    public List<Game> findByGenre(String genre){
        return list.stream()
                .filter(x -> x.containsGenre(genre))
                .collect(Collectors.toList());
    }
    public List<Game> findByPlatform(String platform){
        return list.stream()
                .filter(x -> x.containsPlatform(platform))
                .collect(Collectors.toList());
    }
    public List<Game> findByStore(String store){
        return list.stream()
                .filter(x -> x.containsStore(store))
                .collect(Collectors.toList());
    }
    public List<Game> searchByPrefix(String regex){
        return list.stream()
                .filter(x -> x.getName().matches(regex))
                .collect(Collectors.toList());
    }
}
