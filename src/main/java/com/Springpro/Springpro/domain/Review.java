package com.Springpro.Springpro.domain;

import com.Springpro.Springpro.service.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name="review_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String moviereview;

    private double rating;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable = false)
    @JsonIgnore
    private Movie movie;

    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date updatedDate;

    public static ReviewResponse toReviewResponse(Review review){
        return ReviewResponse.builder()
                .review(review.moviereview)
                .rating(review.rating)
                .build();
    }

    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList){
        if (Objects.isNull(reviewList)) {
            return new ArrayList<>();
        } else {
            return reviewList.stream()
                    .map(Review::toReviewResponse)
                    .collect(Collectors.toList());
        }
    }
}
