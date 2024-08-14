package com.Springpro.Springpro.repository;

import com.Springpro.Springpro.domain.Genre;
import com.Springpro.Springpro.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);

    List<Movie> findByGenre(Genre genre);
}
