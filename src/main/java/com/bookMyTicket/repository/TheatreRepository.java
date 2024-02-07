package com.bookMyTicket.repository;

import com.bookMyTicket.entity.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, Long> {
    List<TheatreEntity> findTheatreIdsByCityId(Long cityId);
}
