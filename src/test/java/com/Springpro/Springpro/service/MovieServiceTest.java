package com.Springpro.Springpro.service;
import com.Springpro.Springpro.domain.Genre;
import com.Springpro.Springpro.domain.Movie;
import com.Springpro.Springpro.repository.MovieRepository;
import com.Springpro.Springpro.service.response.MovieResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    MovieService movieService;
    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testFindMovieByTitle_whenMovieExists() {
        // Arrange
        String title = "Movie Title";


        Movie movie = mock(Movie.class);


        MovieResponse mockMovieResponse = MovieResponse.builder()
                .title(title)
                .build();


        when(movieRepository.findByTitle(title)).thenReturn(movie);
        when(movie.toMovieResponse()).thenReturn(mockMovieResponse);

        MovieResponse result = movieService.findMovie(title);


        System.out.println("Result: " + result);
        System.out.println("Expected Response: " + mockMovieResponse);
        System.out.println("Movie Title: " + movie.getTitle());

        assertEquals("Movie Title", result.getTitle());

    }

    @Test
    void testFindMovieByGenre() {


    }
}