package com.bookMyTicket.services;

import com.bookMyTicket.dto.request.MovieDto;
import com.bookMyTicket.entity.MovieEntity;
import com.bookMyTicket.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

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
}
