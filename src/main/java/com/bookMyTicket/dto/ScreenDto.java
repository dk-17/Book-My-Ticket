package com.bookMyTicket.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ScreenDto {
    @NonNull
    private Long theatreId;

    private Integer numberOfSeats;
}
