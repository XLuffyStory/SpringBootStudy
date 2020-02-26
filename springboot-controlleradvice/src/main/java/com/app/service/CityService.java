package com.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CityRepository;
import com.app.exceptions.CityNotFoundException;
import com.app.exceptions.NoDataFoundException;
import com.app.model.City;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City findById(Long id) {

        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    @Override
    public City save(City city) {

        return cityRepository.save(city);
    }

    @Override
    public List<City> findAll() {

        List<City> cities = (List<City>) cityRepository.findAll();

        if (cities.isEmpty()) {

            throw new NoDataFoundException();
        }

        return cities;
    }

}