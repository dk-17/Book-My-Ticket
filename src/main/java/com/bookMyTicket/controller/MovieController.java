package com.bookMyTicket.controller;

import com.bookMyTicket.dto.request.CityDto;
import com.bookMyTicket.dto.request.MovieDto;
import com.bookMyTicket.entity.CityEntity;
import com.bookMyTicket.entity.MovieEntity;
import com.bookMyTicket.services.CityService;
import com.bookMyTicket.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
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

}
