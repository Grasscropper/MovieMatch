package com.matchbase.MovieMatch.dao;

import com.matchbase.MovieMatch.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieDAO extends CrudRepository<Movie, Long> {

    Movie findOne(Long id);

    List<Movie> findAll();

    List<Movie> findByTitleContaining(String search);


}
