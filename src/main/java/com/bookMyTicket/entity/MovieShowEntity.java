package com.bookMyTicket.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "movieShow")
@Data
@NoArgsConstructor
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"screenId", "theatreId", "startTime"})
})
public class MovieShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private Long movieId;

    private Long screenId;

    private Long theatreId;

    private Integer availableSeats;

    private Date createdOn;

    private Timestamp startTime;

    private Timestamp endTime;
}
