package com.bookMyTicket.repository;

import com.bookMyTicket.entity.ScreensEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<ScreensEntity, Long> {
}
