package com.Springpro.Springpro.service.request;

import com.Springpro.Springpro.domain.Movie;
import com.Springpro.Springpro.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    private String movieReview;

    private double rating;

    private Long movieId;

    public Review toReview(){
        return Review.builder()
                .moviereview(movieReview)
                .rating(rating)
                .movie(Movie.builder()
                        .id(movieId)
                        .build())
                .build();
    }


}
