package com.bookMyTicket.services;

import com.bookMyTicket.dto.MovieDto;
import com.bookMyTicket.dto.MovieShowDto;
import com.bookMyTicket.entity.MovieEntity;
import com.bookMyTicket.entity.MovieShowEntity;
import com.bookMyTicket.repository.MovieRepository;
import com.bookMyTicket.repository.MovieShowRepository;
import com.bookMyTicket.repository.ScreenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Autowired
    private ScreenRepository screenRepository;

    public MovieEntity addMovie(MovieDto movieDto){
        MovieEntity movie = new MovieEntity();
        movie.setName(movieDto.getName());
        movie.setDescription(movieDto.getDescription());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setLanguages(movieDto.getLanguages());
        movie.setDuration(movie.getDuration());

        movieRepository.save(movie);

        return movie;
    }

//    public List<MovieEntity> getMovies(Long cityId, Long theatreId){
//        return  movieRepository.findByCityId(cityId);
//
//    }

    public MovieShowEntity addMovieShow(MovieShowDto movieShowDto) {
        MovieShowEntity movieShow = new MovieShowEntity();
        movieShow.setMovieId(movieShowDto.getMovieId());
        movieShow.setScreenId(movieShowDto.getScreenId());
        movieShow.setTheatreId(movieShowDto.getTheatreId());
        movieShow.setCreatedOn(movieShowDto.getCreatedOn());
        movieShow.setStartTime(movieShowDto.getStartTime());
        movieShow.setEndTime(movieShowDto.getEndTime());

        movieShowRepository.save(movieShow);

        return movieShow;
    }

    public List<MovieShowEntity> getMovieShows(Long movieId, Long theatreId) {
        return movieShowRepository.findByMovieIdAndTheatreId(movieId, theatreId);
    }

    public Optional<MovieShowEntity> getMovieShowDetails(Long showId) {
        Optional<MovieShowEntity> movieShow = movieShowRepository.findById(showId);
        return movieShow;
    }

    public  MovieShowEntity updateAvailableSeats(Long showId, Integer numberOfSeats) {
        Optional<MovieShowEntity> optionalMovieShow = movieShowRepository.findById(showId);

        Long screenId = optionalMovieShow.map(MovieShowEntity::getScreenId).orElse(null);
        Integer totalNumberOfSeats = screenRepository.findById(screenId).get().getNumberOfSeats();
        Integer numberOfSeatsAvailable = totalNumberOfSeats - numberOfSeats;

        MovieShowEntity movieShow = optionalMovieShow.orElseThrow(() -> new RuntimeException("MovieShowEntity not found"));
        movieShow.setAvailableSeats(numberOfSeatsAvailable);

        return movieShow;
    }
}
