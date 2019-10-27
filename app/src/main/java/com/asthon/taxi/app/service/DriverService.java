package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.exception.DriverServiceException;
import com.asthon.taxi.app.model.Coordinates;
import com.asthon.taxi.app.model.Driver;
import com.asthon.taxi.app.model.DriverStatus;
import com.asthon.taxi.app.model.Trip;
import com.asthon.taxi.app.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverRepository;
	@Autowired
	CoordinatesService coordinatesService;

	public List<Driver> getAllDrivers() {
		List<Driver> listDrivers = new ArrayList<Driver>();
		driverRepository.findAll().forEach(listDrivers::add);
		return listDrivers;
	}

	public List<Driver> getAllFreeDrivers() {
		List<Driver> listDrivers = new ArrayList<Driver>();
		driverRepository.findByIsActiveTrueAndIsOnlineTrueAndDriverStatus(DriverStatus.FREE).forEach(listDrivers::add);
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

	public Driver searchFreeDriver(Trip trip) {
		Driver driver = new Driver();
		List<Driver> listFreeDrivers = new ArrayList<Driver>();
		listFreeDrivers = getAllFreeDrivers();
		if (! listFreeDrivers.isEmpty()) {
			driver = findCloserDriver(listFreeDrivers, trip.getStartCoordinates());
			if (driver != null)
				return driver;
			else
				throw new DriverServiceException("There is no free drive at this moment");
		} else {
			throw new DriverServiceException("There is no free drive at this moment");
		}
	}

	public Driver findCloserDriver(List<Driver> listDrivers, Coordinates coordinates) {
		Driver closerDriver = new Driver();
		Double maxDistance = Double.MAX_VALUE;
		for (Driver driver : listDrivers) {
			Double driverDistance = coordinatesService.getDistanceBetweenCoordinates(driver.getCurrentCoordinates(),
					coordinates, "");
			if (driverDistance < maxDistance) {
				maxDistance = driverDistance;
				closerDriver = driver;
			}
		}
		if (sendJobToDriver(closerDriver) == true) {
			return closerDriver;
		} else {
			listDrivers.remove(closerDriver);
			findCloserDriver(listDrivers, coordinates);
		}
		return closerDriver;
	}

	public Boolean sendJobToDriver(Driver driver) {
		// send job to driver
		// send email
		// send sms
		return true;
	}

}
