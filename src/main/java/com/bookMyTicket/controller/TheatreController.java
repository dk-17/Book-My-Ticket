package com.bookMyTicket.controller;


import com.bookMyTicket.dto.TheatreDto;
import com.bookMyTicket.entity.TheatreEntity;
import com.bookMyTicket.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/theatre")
    public ResponseEntity<TheatreEntity> addTheatre(
            @RequestBody TheatreDto theatreDto) {
        TheatreEntity theatre = theatreService.addTheatre(theatreDto);
        return ResponseEntity.ok(theatre);
    }

    /* todo: will enable this endpoint later
    @GetMapping("/theatres")
    public ResponseEntity<List<CityEntity>> getCities(
            @RequestParam(required = true) String state) {
        List<CityEntity> cities = cityService.getCities(state);
        return ResponseEntity.ok(cities);
    }
    */


}
