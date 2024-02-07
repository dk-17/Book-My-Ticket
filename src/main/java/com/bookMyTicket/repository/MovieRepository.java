package com.bookMyTicket.repository;

import com.bookMyTicket.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

      boolean existsByName(String name);

//     // @Query("SELECT m FROM MovieEntity m WHERE m.cityId = :cityId AND (:theatreId IS NULL OR m.theatreId = :theatreId)")
//      List<MovieEntity> findByCityIdAndTheatreId(@Param("cityId") Long cityId, @Param("theatreId") Long theatreId);

      Optional<MovieEntity> findById(Long movieId);
}
