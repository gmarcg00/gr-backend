package dev.spring.firstproject.apibackend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Game implements Serializable {
    public Long getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getReleased() {
        return released;
    }

    public String getBackground_image() {
        return background_image;
    }

    public String getBackground_image_additional() {
        return background_image_additional;
    }

    public String getWebsite() {
        return website;
    }

    public int getPlaytime() {
        return playtime;
    }
    public List<Developer> getDevelopers() {
        return developers;
    }
    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }


    private Long id;
    private String slug;
    private String name;
    private String description;
    private Date released;
    private String background_image;
    private String background_image_additional;
    private String website;
    private int playtime;
    private List<Developer> developers;
    private List<Platform> platforms;

}


