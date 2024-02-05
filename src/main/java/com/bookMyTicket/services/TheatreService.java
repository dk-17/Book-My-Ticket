package com.bookMyTicket.services;

import com.bookMyTicket.dto.request.TheatreDto;
import com.bookMyTicket.entity.TheatreEntity;
import com.bookMyTicket.repository.TheatreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public TheatreEntity addTheatre(TheatreDto theatreDto) {
        TheatreEntity theatre = new TheatreEntity();

        theatre.setName(theatreDto.getName());
        theatre.setCityId(theatreDto.getCityId());
        theatre.setNumberOfScreen(theatreDto.getNumberOfScreen());
        theatre.setAddress(theatreDto.getAddress());

        theatreRepository.save(theatre);

        return theatre;
    }
}
