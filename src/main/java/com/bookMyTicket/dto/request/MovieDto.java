package com.bookMyTicket.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MovieDto {
    private String name;

    private String description;

    private Integer duration;

    private Date releaseDate;

    private List<String> languages;
}
