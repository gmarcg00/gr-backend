package dev.grbackend.services;

import dev.grbackend.models.Review;
import dev.grbackend.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review saveReview (Review review){
        return reviewRepository.save(review);
    }

    public List<Review> getGameReviews (String slug){
        return reviewRepository.findByGame(slug);
    }

    public List<Review> getUserReviews (String userName){
        return reviewRepository.findByUserName(userName);
    }
}
