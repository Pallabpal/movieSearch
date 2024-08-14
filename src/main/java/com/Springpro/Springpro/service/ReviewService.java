package com.Springpro.Springpro.service;

import com.Springpro.Springpro.domain.Movie;
import com.Springpro.Springpro.domain.Review;
import com.Springpro.Springpro.repository.MovieRepository;
import com.Springpro.Springpro.repository.ReviewRepository;
import com.Springpro.Springpro.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addReview(Review review){
        Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);
        if(movie!=null){
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }
    }
    public ReviewResponse getReviewById(Long reviewId){
        Optional<Review> review= reviewRepository.findById(reviewId);
        return review.map(Review::toReviewResponse).orElse(null);

    }

}
