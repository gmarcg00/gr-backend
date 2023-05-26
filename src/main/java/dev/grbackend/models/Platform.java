package dev.grbackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class Platform implements Serializable {
    @JsonProperty
    private Date released_at;
    @JsonProperty
    private PlatformElem platform;
    public Date getReleased_at(){ return released_at; }
    public Platform.PlatformElem getPlatform(){ return platform; }

    public static class PlatformElem implements Serializable{
        @JsonProperty
        private Integer id;
        @JsonProperty
        private String name;
        @JsonProperty
        private String slug;
        @JsonProperty
        private Integer year_start;
        @JsonProperty
        private String image_background;
        @JsonProperty
        private Integer games_count;

        public String getSlug() {
            return slug;
        }
    }
}
