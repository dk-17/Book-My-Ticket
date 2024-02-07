package com.bookMyTicket.repository;

import com.bookMyTicket.entity.MovieShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShowEntity, Long> {
    Optional<MovieShowEntity> findById(Long id);
    List<MovieShowEntity> findByMovieIdAndTheatreId(Long movieId, Long theatreId);
}
