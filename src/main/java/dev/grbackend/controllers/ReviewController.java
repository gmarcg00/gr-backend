package dev.grbackend.controllers;


import dev.grbackend.models.Review;
import dev.grbackend.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping()
    public Review saveReview(@RequestBody Review review){
        return reviewService.saveReview(review);
    }
}
