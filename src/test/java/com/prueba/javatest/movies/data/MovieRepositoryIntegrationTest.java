package com.prueba.javatest.movies.data;

import com.prueba.javatest.movies.model.Genre;
import com.prueba.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static com.prueba.javatest.movies.model.Genre.ACTION;
import static com.prueba.javatest.movies.model.Genre.THRILLER;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;
    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {


        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION)

        )));

    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, THRILLER)));
    }


    @Test
    public void insertAMovie() {
        Movie movie = new Movie("Spiderman2", 112, THRILLER);
        movieRepository.saveOrUpdate(movie);
        Movie movieSavedInDB = movieRepository.findById(4);

        assertThat(movieSavedInDB, is(new Movie(4, "Spiderman2", 112, THRILLER)));
    }

    @Test
    public void find_movies_by_names() {
        Collection<Movie> movies = movieRepository.findByName("m");
        assertThat(movies, is(Arrays.asList(
                new Movie(2,"Memento", 123, Genre.THRILLER),
                new Movie(3,"Matrix", 136, Genre.ACTION),
                new Movie(4,"Superman", 120, Genre.ACTION)
        )));
    }
    @After
    public void tearDown() throws Exception {

       final Statement s= dataSource.getConnection().createStatement();
       s.execute("drop all objects delete files");
    }
    

}