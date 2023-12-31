package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movieName) {
        Movie movie = movieService.getMovie(movieName);
        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String directorName) {
        Director director = movieService.getDirector(directorName);
        return ResponseEntity.ok(director);
    }

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movieName, @RequestParam("director") String directorName) {
        movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String directorName) {
        List<String> listOfMoviesName = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity(listOfMoviesName, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies() {
        List<String> listOfMoviesName = movieService.findAllMovies();
        return new ResponseEntity(listOfMoviesName, HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("director") String directorName) {
        movieService.deleteDirectorName(directorName);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity("success", HttpStatus.OK);
    }

}
