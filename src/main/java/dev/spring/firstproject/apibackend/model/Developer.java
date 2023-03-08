package dev.spring.firstproject.apibackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Developer implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(String gamesCount) {
        this.gamesCount = gamesCount;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }


    private int id;
    private String slug;
    private String name;
    @JsonProperty("games_count")
    private String gamesCount;
    @JsonProperty("image_background")
    private String imageBackground;
}
