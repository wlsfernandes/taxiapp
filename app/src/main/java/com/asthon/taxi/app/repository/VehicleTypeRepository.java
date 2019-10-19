package com.asthon.taxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.VehicleType;

public interface VehicleTypeRepository extends CrudRepository<VehicleType, Long> {

}
