package com.asthon.taxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.Driver;
import com.asthon.taxi.app.model.DriverStatus;

public interface DriverRepository extends CrudRepository<Driver, Long>{

	Driver findByTag(String tag);

	Iterable<Driver> findByDriverStatus(DriverStatus driverStatus);
	
	

}
