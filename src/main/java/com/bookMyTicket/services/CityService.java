package com.bookMyTicket.services;

import com.bookMyTicket.dto.CityDto;
import com.bookMyTicket.entity.CityEntity;
import com.bookMyTicket.exception.CityAlreadyExistsException;
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

    public CityEntity addCity(CityDto cityDto) throws CityAlreadyExistsException {
        String cityName = cityDto.getName();
        String state = cityDto.getState();

        if (cityRepository.existsByNameAndState(cityName, state)) {
            //TODO status is 500 is it right?
            throw new CityAlreadyExistsException("City '" + cityName + "' already exists in state '" + state + "'");
        }

        CityEntity city = new CityEntity();
        city.setState(state);
        city.setName(cityName);

        cityRepository.save(city);

        log.info("Successfully added city '{}' in state '{}'", cityName, state);

        return city;
    }


    public List<CityEntity> getCities(String state) {
        List<CityEntity> cities = cityRepository.findByState(state);
        if (cities.isEmpty()) {
            log.warn("No cities found for state '{}'", state);
        }
        return cities;
    }

}
