package com.bookMyTicket.services;

import com.bookMyTicket.dto.ScreenDto;
import com.bookMyTicket.entity.ScreensEntity;
import com.bookMyTicket.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    public ScreensEntity addScreen(ScreenDto screenDto) {
        ScreensEntity screen = new ScreensEntity();
        screen.setTheatreId(screenDto.getTheatreId());
        screen.setNumberOfSeats(screenDto.getNumberOfSeats());

        screenRepository.save(screen);

        return screen;
    }
}
