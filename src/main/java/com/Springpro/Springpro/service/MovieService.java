package com.Springpro.Springpro.service;

import com.Springpro.Springpro.domain.Genre;
import com.Springpro.Springpro.domain.Movie;
import com.Springpro.Springpro.repository.MovieRepository;
import com.Springpro.Springpro.service.response.MovieResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieResponse findMovie(String title) {
        Movie movie = movieRepository.findByTitle(title);

        if(Objects.nonNull(movie))
          return movie.toMovieResponse();
        return null;
    }

    public List<MovieResponse> findMovieByGenre(String genre) {
        // Check if the provided genre exists in the Genre enum
        if (Arrays.stream(Genre.values()).noneMatch(g -> g.toString().equals(genre)))
            return new ArrayList<>();

        // Retrieve the list of movies by genre
        List<Movie> movieList = movieRepository.findByGenre(Genre.valueOf(genre));

        // Check if the movie list is empty
        if (!CollectionUtils.isEmpty(movieList)) {
            // Map the movie list to movie responses, sort by rating in descending order
                List<MovieResponse> movieResponseList = movieList.stream()
                        .sorted(Comparator.comparing(Movie::getRating).reversed())
                        .map(Movie::toMovieResponse)
                        .collect(Collectors.toList());

            // If the response list has more than 5 elements, return the first 5
            if (movieResponseList.size() > 5)
                return movieResponseList.subList(0, 5);

            return movieResponseList;
        }

        // Return an empty list if no movies found
        return new ArrayList<>();
    }

}
