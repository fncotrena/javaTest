package com.prueba.javatest.movies.service;

import com.prueba.javatest.movies.data.MovieRepository;
import com.prueba.javatest.movies.model.Genre;
import com.prueba.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.prueba.javatest.movies.model.Genre.ACTION;
import static com.prueba.javatest.movies.model.Genre.THRILLER;
import static com.prueba.javatest.movies.model.Genre.COMEDY;
import static com.prueba.javatest.movies.model.Genre.HORROR;

import static org.junit.Assert.*;

public class MovieServiceTest {
    private MovieService movieService;
    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository= Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "There's Something About Mary", 119, COMEDY),
                        new Movie(4, "Super 8", 112, THRILLER),
                        new Movie(5, "Scream", 111, HORROR),
                        new Movie(6, "Home Alone", 103, COMEDY),
                        new Movie(7, "Matrix", 136, ACTION)
                )
        );
         movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movie_by_genre() {

        Collection <Movie>movies = movieService.findMoviesByGenre(COMEDY);
        List<Integer> moviesIds = getMoviesIds(movies);

        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(3,6)) );
    }

    @Test
    public void return_movies_by_duration() {
        Collection <Movie>movies =  movieService.findMoviesByLength(120);
        List<Integer> moviesIds = getMoviesIds(movies);

        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(2,3,4,5,6)) );
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
    }
}
