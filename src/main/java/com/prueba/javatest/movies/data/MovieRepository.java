package com.prueba.javatest.movies.data;

import com.prueba.javatest.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
    Collection<Movie> findByName(String name);
 //   Collection<Movie>  findByDirector(String name);
}
