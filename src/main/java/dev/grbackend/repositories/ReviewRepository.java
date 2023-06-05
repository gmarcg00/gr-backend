package dev.grbackend.repositories;


import dev.grbackend.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long> {
    public abstract List<Review> findByGame(String slug);
    public abstract List<Review> findByUserName(String slug);
}
