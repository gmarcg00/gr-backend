package dev.grbackend.services;

import dev.grbackend.models.Review;
import dev.grbackend.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review saveReview (Review review){
        return reviewRepository.save(review);
    }
}
