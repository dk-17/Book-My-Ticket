package com.bookMyTicket.repository;

import com.bookMyTicket.entity.BookingEntity;
import com.bookMyTicket.entity.MovieShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    Optional<BookingEntity> findById(Long id);
}
