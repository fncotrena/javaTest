package com.prueba.javatest.movies.model;

import java.util.Objects;

public class Movie {
    private Integer id;
    private String names;
    private int minutes;
    private  Genre genre;

    public Movie (String name, int minutes, Genre genre) {
        // this: call the second constructor.
        this(null, name, minutes, genre);
    }

    public Movie(Integer id, String names, int minutes, Genre genre) {
        this.id = id;
        this.names = names;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes &&
                Objects.equals(id, movie.id) &&
                Objects.equals(names, movie.names) &&
                genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, names, minutes, genre);
    }
}
