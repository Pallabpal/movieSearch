package com.Springpro.Springpro.controller;

import com.Springpro.Springpro.domain.Review;
import com.Springpro.Springpro.service.ReviewService;
import com.Springpro.Springpro.service.request.ReviewRequest;
import com.Springpro.Springpro.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/review/add")
    public void  addReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());
    }

    @GetMapping("/review/find")
    public ReviewResponse getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }

}


