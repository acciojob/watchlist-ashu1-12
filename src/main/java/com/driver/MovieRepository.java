package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MovieRepository {

    Map<String, Movie> moviesdb = new HashMap<>();
    Map<String, Director> directordb=new HashMap<>();
    Map<String,List<String>> movieDirector_db = new HashMap<>();
    //get mmovie
    public Movie getMovie(String movieName) {
        return moviesdb.get(movieName);
    }
    //add movie
    public void addMovie(Movie movie) {
        moviesdb.put(movie.getName(),movie);
    }
    //add director
    public void addDirector(Director director) {
        directordb.put(director.getName(),director);
    }
    //get the director
    public Director getDirector(String directorName) {
        return directordb.get(directorName);
    }

    //list of all movies
    public List<String> findAllMovies() {
        List<String> listOfAllMovies = new ArrayList<>(moviesdb.keySet());
        return listOfAllMovies;
    }

    //pairing existing movies and director
    public void addMovieDirectorPair(String movieName, String directorName) {
        if(movieDirector_db.containsKey(directorName)){
            List<String> movies = movieDirector_db.get(directorName);
            movies.add(movieName);
        }else{
            List<String> movies = new ArrayList<>();
            movies.add(movieName);
            movieDirector_db.put(directorName,movies);
        }
    }
    //list of movies by director
    public List<String> getMoviesByDirectorName(String directorName) {
        return movieDirector_db.get(directorName);
    }

    //delete director and its movies from records.
    public void deleteDirectorName(String directorName) {
        List<String> movies = movieDirector_db.get(directorName);
        for(String movieName : movies)
            moviesdb.remove(movieName);
        directordb.remove(directorName);
        movieDirector_db.remove(directorName);
    }

    //delete all directors and movies records.
    public void deleteAllDirectors() {
        moviesdb.clear();
        directordb.clear();
        movieDirector_db.clear();
    }
}
