package com.Springpro.Springpro.service;

import com.Springpro.Springpro.domain.Movie;
import com.Springpro.Springpro.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private MovieRepository movieRepository;
    public Movie addMovie(Movie movie) {

        return movieRepository.save(movie);

    }



}