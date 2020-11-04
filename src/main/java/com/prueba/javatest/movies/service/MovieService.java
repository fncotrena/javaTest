package com.prueba.javatest.movies.service;

import com.prueba.javatest.movies.data.MovieRepository;
import com.prueba.javatest.movies.model.Genre;
import com.prueba.javatest.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {
 MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection findMoviesByGenre(Genre genre) {

        Collection<Movie> allMovies = movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre()==genre).collect(Collectors.toList());
         return allMovies;
    }

    public Collection<Movie> findMoviesByLength(int minutes) {
        Collection<Movie> allMovies = movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes()<= minutes).collect(Collectors.toList());
        return allMovies;    }
}
