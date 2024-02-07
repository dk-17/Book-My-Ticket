package com.bookMyTicket.services;

import com.bookMyTicket.dto.MovieDto;
import com.bookMyTicket.dto.MovieShowDto;
import com.bookMyTicket.entity.MovieEntity;
import com.bookMyTicket.entity.MovieShowEntity;
import com.bookMyTicket.entity.TheatreEntity;
import com.bookMyTicket.exception.DuplicateEntityException;
import com.bookMyTicket.exception.NotFoundException;
import com.bookMyTicket.repository.MovieRepository;
import com.bookMyTicket.repository.MovieShowRepository;
import com.bookMyTicket.repository.ScreenRepository;
import com.bookMyTicket.repository.TheatreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Autowired
    private ScreenRepository screenRepository;

    public MovieEntity addMovie(MovieDto movieDto) {
        if (movieRepository.existsByName(movieDto.getName())) {
            throw new DuplicateEntityException("Movie with name '" + movieDto.getName() + "' already exists.");
        }

        MovieEntity movie = new MovieEntity();
        movie.setName(movieDto.getName());
        movie.setDescription(movieDto.getDescription());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setLanguages(movieDto.getLanguages());
        movie.setDuration(movieDto.getDuration());

        movie = movieRepository.save(movie);

        log.info("Movie '{}' added successfully.", movie.getName());

        return movie;
    }


    public List<MovieEntity> getMovies(Long cityId) {
        List<TheatreEntity> theatres = theatreRepository.findTheatreIdsByCityId(cityId);
        List<Long> theatreIds = theatres.stream().map(TheatreEntity::getId).collect(Collectors.toList());


        List<Long> movieIds = new ArrayList<>();
        for (Long theatreId : theatreIds) {
            List<MovieShowEntity> movieShowEntities = movieShowRepository.findMovieIdsByTheatreId(theatreId);
            List<Long> theatreMovieIds = movieShowEntities.stream().map(MovieShowEntity::getId).collect(Collectors.toList());
            movieIds.addAll(theatreMovieIds);
        }

        List<MovieEntity> movies = new ArrayList<>();
        for (Long movieId: movieIds) {
            Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(movieId);
            if (optionalMovieEntity.isPresent()) {
                MovieEntity movieEntity = optionalMovieEntity.get();
                movies.add(movieEntity);
            } else {
                log.info("Movie not found with id {}", movieId);
            }
        }

        return movies;
    }

    public MovieEntity getMovieById(Long movieId) {
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(movieId);
        if (optionalMovieEntity.isEmpty()) {
            throw new NotFoundException("Movie not found with id " + movieId);
        }

        return optionalMovieEntity.get();
    }


    public MovieShowEntity addMovieShow(MovieShowDto movieShowDto) {
        MovieShowEntity movieShow = new MovieShowEntity();
        movieShow.setMovieId(movieShowDto.getMovieId());
        movieShow.setScreenId(movieShowDto.getScreenId());
        movieShow.setTheatreId(movieShowDto.getTheatreId());
        movieShow.setCreatedOn(movieShowDto.getCreatedOn());
        movieShow.setStartTime(movieShowDto.getStartTime());
        movieShow.setEndTime(movieShowDto.getEndTime());

        try {
            movieShowRepository.save(movieShow);
            log.info("Movie show added successfully: {}", movieShow);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateEntityException("Movie show already exists at the same screen, theater, and start time");
        }

        return movieShow;
    }


    public List<MovieShowEntity> getMovieShows(Long movieId, Long cityId) {
        List<TheatreEntity> theatres = theatreRepository.findTheatreIdsByCityId(cityId);
        List<Long> theatreIds = theatres.stream().map(TheatreEntity::getId).collect(Collectors.toList());

        List<MovieShowEntity> movieShows = new ArrayList<>();

        for(Long theatreId : theatreIds) {
            List<MovieShowEntity> movieShowsByTheatreId = movieShowRepository.findByMovieIdAndTheatreId(movieId, theatreId);
            movieShows.addAll(movieShowsByTheatreId);
        }

        return movieShows;
    }

    public Optional<MovieShowEntity> getMovieShowDetails(Long showId) {
        return movieShowRepository.findById(showId);
    }

    public  MovieShowEntity updateAvailableSeats(Long showId, Integer numberOfSeats) {
        Optional<MovieShowEntity> optionalMovieShow = movieShowRepository.findById(showId);

        Long screenId = optionalMovieShow.map(MovieShowEntity::getScreenId).orElse(null);
        Integer totalNumberOfSeats = screenRepository.findById(screenId).get().getNumberOfSeats();
        Integer numberOfSeatsAvailable = totalNumberOfSeats - numberOfSeats;

        MovieShowEntity movieShow = optionalMovieShow.orElseThrow(() -> new RuntimeException("MovieShowEntity not found"));
        movieShow.setAvailableSeats(numberOfSeatsAvailable);

        movieShowRepository.save(movieShow);

        return movieShow;
    }
}
