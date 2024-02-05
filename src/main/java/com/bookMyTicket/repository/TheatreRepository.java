package com.bookMyTicket.repository;

import com.bookMyTicket.entity.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, Long> {
}
