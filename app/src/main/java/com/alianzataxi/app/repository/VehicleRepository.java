package com.alianzataxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.alianzataxi.app.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

}
