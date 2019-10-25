package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.Coordinates;
import com.asthon.taxi.app.model.Driver;
import com.asthon.taxi.app.model.DriverStatus;
import com.asthon.taxi.app.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverRepository;
	@Autowired
	CoordinatesService coordinatesService;
	
	public List<Driver> getAllDrivers(){
		List<Driver> listDrivers = new ArrayList<Driver>();
		driverRepository.findAll().forEach(listDrivers::add);
		return listDrivers;
	}
	

	public List<Driver> getAllFreeDrivers(){
		List<Driver> listDrivers = new ArrayList<Driver>();
		driverRepository.findByDriverStatus(DriverStatus.FREE).forEach(listDrivers::add);
		return listDrivers;
	}

	
	public Driver getDriverById(Long id) {
		return driverRepository.findById(id).orElse(null);
	}
	
	public Driver getDriverByTag(String tag) {
		return driverRepository.findByTag(tag);
	}
	
	public Driver addDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
	public Driver updateDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
	public void removeDriver(Long id) {
		driverRepository.deleteById(id);
	}

	public Driver findNearFreeDriver(Coordinates coordinates) {
		List<Driver> listFreeDrivers = new ArrayList<Driver>();
		listFreeDrivers = getAllFreeDrivers();
		return getCloserDriver(listFreeDrivers, coordinates);
	}
		
	public Driver getCloserDriver(List<Driver> listDrivers, Coordinates coordinates) {
		return coordinatesService.findCloserDriver(listDrivers,coordinates);
	}
}
