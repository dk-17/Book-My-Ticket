package com.bookMyTicket.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MovieShowDto {
    @NonNull
    private Long movieId;
    @NonNull
    private Long screenId;
    @NonNull
    private Long theatreId;

    @NonNull
    private Long cityId;

    private Date createdOn;

    private Timestamp startTime;

    private Timestamp endTime;
}
