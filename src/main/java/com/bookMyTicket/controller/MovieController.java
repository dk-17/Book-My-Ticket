package com.bookMyTicket.controller;

import com.bookMyTicket.dto.MovieDto;
import com.bookMyTicket.dto.MovieShowDto;
import com.bookMyTicket.entity.MovieEntity;
import com.bookMyTicket.entity.MovieShowEntity;
import com.bookMyTicket.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("")
    public ResponseEntity<MovieEntity> addMovie(
            @RequestBody MovieDto movieDto) {
        MovieEntity movie = movieService.addMovie(movieDto);
        return ResponseEntity.ok(movie);
    }


    @GetMapping("")
    public ResponseEntity<List<MovieEntity>> getMovies(
            @RequestParam(required = true) Long cityId) {
        List<MovieEntity> movies = movieService.getMovies(cityId);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieEntity> getMovieById(
            @PathVariable Long movieId,
            @RequestParam(required = true) Long cityId) {
        MovieEntity movies = movieService.getMovieById(movieId);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/{movieId}/shows")
    public ResponseEntity<MovieShowEntity> addMovieShow(
            @PathVariable Long movieId,
            @RequestParam MovieShowDto movieShowDto) {
        MovieShowEntity movieShows = movieService.addMovieShow(movieShowDto);
        return ResponseEntity.ok(movieShows);
    }


    @GetMapping("/{movieId}/shows")
        public ResponseEntity< List<MovieShowEntity>> getMovieShows(
                @PathVariable Long movieId,
                @RequestParam(required = true) Long cityId) {
            List<MovieShowEntity> movieShows = movieService.getMovieShows(movieId, cityId);
            return ResponseEntity.ok(movieShows);
    }

    @GetMapping("/show/{showId}")
    public ResponseEntity<MovieShowEntity> getMovieShowsDetails(
            @PathVariable Long showId) {
        MovieShowEntity movieShows = movieService.getMovieShowDetails(showId);
        return ResponseEntity.ok(movieShows);
    }
}
