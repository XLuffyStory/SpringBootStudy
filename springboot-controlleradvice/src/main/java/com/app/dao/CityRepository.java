package com.app.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}