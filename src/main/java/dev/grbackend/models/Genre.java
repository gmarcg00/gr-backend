package dev.grbackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Genre implements Serializable {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String slug;
    @JsonProperty
    private String games_count;
    @JsonProperty
    private String image_background;
    public String getSlug() {
        return slug;
    }
}
