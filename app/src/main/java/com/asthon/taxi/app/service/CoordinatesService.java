package com.asthon.taxi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.Coordinates;
import com.asthon.taxi.app.model.Driver;

@Service
public class CoordinatesService {

	@Autowired
	CoordinatesRepository coordinatesRepository;

	public Coordinates getCoordinates(Long id) {
		return coordinatesRepository.findById(id).orElse(null);
	}

	public Coordinates addCoordinates(Coordinates coordinates) {
		return coordinatesRepository.save(coordinates);
	}

	public Coordinates updateCoordinates(Coordinates coordinates) {
		return coordinatesRepository.save(coordinates);
	}

	public void removeCoordinates(Long id) {
		coordinatesRepository.deleteById(id);
	}

	public Driver findCloserDriver(List<Driver> listDrivers, Coordinates coordinates) {
		
		Driver closerDriver = new Driver();

		Double maxDistance = Double.MAX_VALUE;
		for (Driver driver : listDrivers) {
			Double driverDistance = compareCoordinates(driver.getCurrentCoordinates(), coordinates);
			if (driverDistance < maxDistance) {
				driverDistance = maxDistance;
			closerDriver = driver;
			}
		}
		return closerDriver;
	}

	public Double compareCoordinates(Coordinates initial, Coordinates target) {
		Double x1, x2, y1, y2 = 0.0;
		x1 = initial.getLatitude();
		x2 = initial.getLongitude();
		y1 = target.getLatitude();
		y2 = target.getLongitude();

		return null;
	}

}
