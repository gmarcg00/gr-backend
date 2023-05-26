package dev.grbackend.response.model;

import dev.grbackend.models.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GamesResponse implements Serializable {
    private List<Game> results = new ArrayList<>();
    private Integer count;
    private String next;
    private String previous;
    public List<Game> getResults() {
        return results;
    }

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

}
