package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie getMovie(String movieName) {
        return movieRepository.getMovie(movieName);
    }

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public Director getDirector(String directorName) {
        return movieRepository.getDirector(directorName);
    }

    public List getMoviesByDirectorName(String directorName) {
        List<String> listOfMovies=movieRepository.getMoviesByDirectorName(directorName);
        return  listOfMovies;

    }

    public List<String> findAllMovies() {
        List<String> listOfMoviesName =movieRepository.findAllMovies();
        return listOfMoviesName;
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        movieRepository.addMovieDirectorPair(movieName,directorName);
        return;
    }

    public void deleteDirectorName(String directorName) {
        movieRepository.deleteDirectorName(directorName);
        return;
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
        return;
    }
}
