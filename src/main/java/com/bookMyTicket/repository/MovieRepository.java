package com.bookMyTicket.repository;

import com.bookMyTicket.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
//    List<MovieEntity> findByCityId(Long cityId);
//
//    List<MovieEntity> findByCityIdAndTheatreId(Long cityId, Long theatreId);
}
