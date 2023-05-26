package dev.grbackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Store implements Serializable {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private StoreElem storeElem;
    public Store.StoreElem getStoreElem() {
        return storeElem;
    }
    public static class StoreElem implements Serializable {
        @JsonProperty
        private Integer id;
        @JsonProperty
        private String name;
        @JsonProperty
        private String slug;
        @JsonProperty(value = "domain")
        private String webSite;
        @JsonProperty
        private String image_background;
        @JsonProperty
        private Integer games_count;

        public String getSlug() {
            return slug;
        }
    }

}
