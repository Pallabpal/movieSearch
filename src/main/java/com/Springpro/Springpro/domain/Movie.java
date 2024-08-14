package com.Springpro.Springpro.domain;

import com.Springpro.Springpro.service.response.MovieResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.util.List;
//import com.gfg.shoutreview.service.response.MovieResponse;


@Entity
@Table(name="movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Movie {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Double rating;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public MovieResponse toMovieResponse(){
        return MovieResponse.builder()
                .genre(this.genre)
                .title(this.title)
                .rating(this.rating)
                .reviews(Review.toReviewResponse(this.reviews))
                .build();
    }
}

