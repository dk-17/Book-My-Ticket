package com.bookMyTicket.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "screens")
@Data
@NoArgsConstructor
public class ScreensEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private Long theatreId;

    private Integer numberOfSeats;

}
