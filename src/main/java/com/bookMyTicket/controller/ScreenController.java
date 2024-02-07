package com.bookMyTicket.controller;

import com.bookMyTicket.dto.ScreenDto;
import com.bookMyTicket.entity.ScreensEntity;
import com.bookMyTicket.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ScreenController {
    @Autowired
    private ScreenService screenService;

    @PostMapping("/screen")
    public ResponseEntity<ScreensEntity> addScreen(
            @RequestBody ScreenDto screenDto){
        ScreensEntity screen = screenService.addScreen(screenDto);
        return ResponseEntity.ok(screen);
    }

}
