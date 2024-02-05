package com.bookMyTicket.services;

import com.bookMyTicket.dto.request.CityDto;
import com.bookMyTicket.entity.CityEntity;
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

    public CityEntity addCity(CityDto cityDto) {
        CityEntity city = new CityEntity();
        city.setState(cityDto.getState());
        city.setName(cityDto.getName());

        cityRepository.save(city);

        return city;
    }

    public  List<CityEntity> getCities(String state) {
        return cityRepository.findByState(state);
    }
}
