package com.bookMyTicket.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class TheatreDto {
    private String name;
    @NonNull
    private Long cityId;
    private String address;
    private Integer numberOfScreen;
}
