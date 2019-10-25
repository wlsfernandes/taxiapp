package com.asthon.taxi.app.service;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.Coordinates;

public interface CoordinatesRepository extends CrudRepository<Coordinates, Long> {

}
