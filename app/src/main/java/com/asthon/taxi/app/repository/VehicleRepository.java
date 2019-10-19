package com.asthon.taxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

}
