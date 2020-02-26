package com.app.service;

import java.util.List;
import com.app.model.City;

public interface ICityService {

    City findById(Long id);

    City save(City city);

    List<City> findAll();
}