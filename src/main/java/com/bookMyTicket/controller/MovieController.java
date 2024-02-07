package com.bookMyTicket.controller;

import com.bookMyTicket.dto.MovieDto;
import com.bookMyTicket.dto.MovieShowDto;
import com.bookMyTicket.entity.MovieEntity;
import com.bookMyTicket.entity.MovieShowEntity;
import com.bookMyTicket.services.MovieService;
import com.bookMyTicket.services.MovieShowService;
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

    @Autowired
    private MovieShowService movieShowService;

    @PostMapping("")
    public ResponseEntity<MovieEntity> addMovie(
            @RequestBody MovieDto movieDto) {
        MovieEntity movie = movieService.addMovie(movieDto);
        return ResponseEntity.ok(movie);
    }


//    @GetMapping("/movies")
//    public ResponseEntity<List<MovieEntity>> getMovies(
//            @RequestParam(required = true) Long cityId,
//            @RequestParam Long theatreId) {
//        List<MovieEntity> movies = movieService.getMovies(cityId, theatreId);
//        return ResponseEntity.ok(movies);
//    }

        @GetMapping("/movies/{movieId}/shows")
            public ResponseEntity< List<MovieShowEntity>> getMovieShows(
                    @PathVariable Long movieId,
                    @RequestParam(required = true) Long theatreId) {
                List<MovieShowEntity> movieShows = movieShowService.getMovieShows(movieId, theatreId);
                return ResponseEntity.ok(movieShows);
            }

        @PostMapping("/movies/{movieId}/shows")
        public ResponseEntity<MovieShowEntity> addMovieShow(
                @PathVariable Long movieId,
                @RequestParam MovieShowDto movieShowDto) {
            MovieShowEntity movieShows = movieShowService.addMovieShow(movieShowDto);
            return ResponseEntity.ok(movieShows);
        }

    @GetMapping("/movies/{movieId}/shows/{showId}")
    public ResponseEntity< Optional<MovieShowEntity>> getMovieShowsDetails(
            @PathVariable Long movieId,
            @PathVariable Long showId) {
        Optional<MovieShowEntity> movieShows = movieShowService.getMovieShowDetails(showId);
        return ResponseEntity.ok(movieShows);
    }



}
