// package sg.ntu.edu.simplecrm;
package sg.edu.ntu.movie_api.controllers;


import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public ResponseEntity<ArrayList<Movie>> searchMovies(@RequestParam String movieTitle) {
        ArrayList<Movie> foundMovies = movieService.searchMovies(movieTitle);
        return new ResponseEntity<>(foundMovies, HttpStatus.OK);
    }

    // Create
    @PostMapping("")
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie) {
        Movie newMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    // Get all
    @GetMapping("")
    public ResponseEntity<ArrayList<Movie>> getAllMovie() {
        ArrayList<Movie> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    // Get one
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long movieId) {
        Movie foundMovie = movieService.getMovie(movieId;
        return new ResponseEntity<>(foundMovie, HttpStatus.OK));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long movieId, @RequestBody Movie movie) {
        Movie updateddMovie = movieService.updateMovie(movieId, movie);
        return new ResponseEntity<>(updateddMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // TODO: Add validation for interaction?
}
