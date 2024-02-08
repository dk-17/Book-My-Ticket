package com.bookMyTicket.services;

import com.bookMyTicket.dto.CityDto;
import com.bookMyTicket.entity.CityEntity;
import com.bookMyTicket.exception.DuplicateEntityException;
import com.bookMyTicket.exception.NotFoundException;
import com.bookMyTicket.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityEntity addCity(CityDto cityDto) throws DuplicateEntityException {
        String cityName = cityDto.getName();
        String state = cityDto.getState();

        if (cityRepository.existsByNameAndState(cityName, state)) {
            throw new DuplicateEntityException("City '" + cityName + "' already exists in state '" + state + "'");
        }

        CityEntity city = new CityEntity();
        city.setState(state);
        city.setName(cityName);

        cityRepository.save(city);

        log.info("Successfully added city '{}' in state '{}'", cityName, state);

        return city;
    }


    public List<CityEntity> getCities(String state) throws NotFoundException {
        List<CityEntity> cities = cityRepository.findByState(state);
        if (cities.isEmpty()) {
            throw new NotFoundException("No cities found for the state '" + state + "'. Please check the state abbreviation or contact support for assistance.");
        }
        return cities;
    }

}
