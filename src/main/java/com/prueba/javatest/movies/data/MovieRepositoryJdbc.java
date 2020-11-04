package com.prueba.javatest.movies.data;

import com.prueba.javatest.movies.model.Genre;
import com.prueba.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {

private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
      Object[] args ={id};

        return jdbcTemplate.queryForObject("select * from movies where id = ?", args,movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies",movieMapper);
    }

    @Override
        public void saveOrUpdate(Movie movie) {
            jdbcTemplate.
                    update(
                            "INSERT INTO movies(name, minutes, genre) VALUES(?, ?, ?)",
                            movie.getNames(),
                            movie.getMinutes(),
                            movie.getGenre().toString()
                    );
        }

    @Override
    public Collection<Movie> findByName(String name) {
        return findAll().stream().filter(movie -> movie.getNames().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }



    private static final RowMapper<Movie>movieMapper = (rs, i) ->
            new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")));
}
