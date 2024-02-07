package com.bookMyTicket.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingDto {
    @NonNull
    private Long showId;

    @NonNull
    private Long userId;

    private Integer numberOfSeats;

    private Date createdOn;
}
