package dev.spring.firstproject.apibackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Platform {
    private PlatformObject platform;
    @JsonProperty("released_at")
    private Date releaseDate;

    public PlatformObject getPlatform() {
        return platform;
    }
    public void setPlatform(PlatformObject platform) {
        this.platform = platform;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    private static class PlatformObject{
        private Long id;
        private String slug;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
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
    }

}
