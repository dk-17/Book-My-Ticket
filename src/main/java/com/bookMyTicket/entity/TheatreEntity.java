package com.bookMyTicket.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "theatres")
@Data
@NoArgsConstructor
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String name;
    @NonNull
    private Long cityId;
    private String address;
    private Integer numberOfScreen;
}
