package dev.grbackend.models;

import jakarta.persistence.*;


import java.util.Date;
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = true, nullable = false)
    private String slug;
    private String name;
    @Column(length = 2500)
    private String description;
    private Date released;
    private String background_image;
    private String background_image_additional;
    private String website;
    private int playtime;

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


}
