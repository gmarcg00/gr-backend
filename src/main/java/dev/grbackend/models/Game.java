package dev.grbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @Column(unique = true, nullable = false)
    @JsonProperty
    private Long id;
    @JsonProperty
    @Column(unique = true, nullable = false)
    private String slug;
    @JsonProperty
    private String name;
    @JsonProperty
    private Date released;
    @JsonProperty
    private String background_image;
    @JsonProperty
    private int playtime;
    @JsonProperty
    private List<Genre> genres = new ArrayList<>();
    @JsonProperty
    private List<Platform> platforms = new ArrayList<>();
    @JsonProperty
    private List<Store> stores = new ArrayList<>();
    public Long getId() {
        return id;
    }
    public String getSlug() {
        return slug;
    }
    public String getName() {
        return name;
    }
    public Date getReleased() {
        return released;
    }
    public String getBackground_image() {
        return background_image;
    }
    public int getPlaytime() {
        return playtime;
    }
    public List<Genre> getGenres(){ return genres;}
    public List<Platform> getPlatforms() {return platforms;}
    public List<Store> getStores() {return stores;}

    @JsonIgnore
    public boolean containsGenre(String genre){
        for(Genre elem: this.genres){
            if(elem.getSlug().equals(genre)) return true;
        }
        return false;
    }
    @JsonIgnore
    public boolean containsPlatform(String platform){
        for(Platform elem: this.platforms){
            if(elem.getPlatform() != null){
                if(elem.getPlatform().getSlug().equals(platform)) return true;
            }
        }
        return false;
    }
    @JsonIgnore
    public boolean containsStore(String store){
        for(Store elem: this.stores){
            if(elem.getStoreElem() != null){
                if(elem.getStoreElem().getSlug().equals(store)) return true;
            }
        }
        return false;
    }
}
