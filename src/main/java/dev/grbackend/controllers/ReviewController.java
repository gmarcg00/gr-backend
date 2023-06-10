package dev.grbackend.controllers;


import dev.grbackend.models.Review;
import dev.grbackend.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping()
    public ResponseEntity<Review> saveReview(@RequestBody Review review){
         Review result = reviewService.saveReview(review);
         if(result != null) return new ResponseEntity<>(result, HttpStatus.CREATED);
         else return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/game/{slug}")
    public ResponseEntity<List<Review>> getGameReviews (@PathVariable ("slug") String slug){
        List<Review> result = reviewService.getGameReviews(slug);
        if(result != null) return new ResponseEntity<>(result, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
    @GetMapping("user/{userName}")
    public ResponseEntity<List<Review>> getUserReviews(@PathVariable ("userName") String userName){
        List<Review> result = reviewService.getUserReviews(userName);
        if(result != null) return new ResponseEntity<>(result, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
