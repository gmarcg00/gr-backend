package dev.grbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table (name = "reaction")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String userName;
    private String slug;
    private String reactionType;

    public Reaction(){}
    @JsonIgnore
    public Reaction(String userName, String slug, String reactionType){
        this.userName = userName;
        this.slug = slug;
        this.reactionType = reactionType;
    }
    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getSlug() {
        return slug;
    }

    public String getReactionType() {
        return reactionType;
    }



}
