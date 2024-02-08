package com.bookMyTicket.controller;

import com.bookMyTicket.dto.CityDto;
import com.bookMyTicket.entity.CityEntity;
import com.bookMyTicket.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity<CityEntity> addCity(
            @RequestBody CityDto cityDto) {
        CityEntity city = cityService.addCity(cityDto);
        return ResponseEntity.ok(city);
    }


    @GetMapping("/cities")
    public ResponseEntity< List<CityEntity>> getCities(
            @RequestParam(required = true) String state) {
        List<CityEntity> cities = cityService.getCities(state);
        return ResponseEntity.ok(cities);
    }

}
