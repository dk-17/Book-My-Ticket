package com.bookMyTicket.repository;

import com.bookMyTicket.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
    List<CityEntity> findByState(String state);
    boolean existsByNameAndState(String name, String state);
}
