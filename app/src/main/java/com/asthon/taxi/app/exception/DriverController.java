package com.asthon.taxi.app.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asthon.taxi.app.model.Driver;
import com.asthon.taxi.app.service.DriverService;

@RestController
public class DriverController {

	Logger logger = Logger.getLogger(DriverController.class.getName());
	@Autowired
	DriverService driverService;

	@GetMapping("/api/drivers")
	public List<Driver> getAllDrivers() {
		try {
			List<Driver> listDrivers = new ArrayList<Driver>();
			listDrivers = driverService.getAllDrivers();
			if (listDrivers.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drivers list not found");
			return listDrivers;
		} catch (DriverServiceException e) {
			logger.log(Level.SEVERE, "Error to list Drivers");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Drivers list not found");
		}
	}

	@GetMapping("/api/freedrivers")
	public List<Driver> getAllFreeDrivers() {
		try {
			List<Driver> listDrivers = new ArrayList<Driver>();
			listDrivers = driverService.getAllFreeDrivers();
			if (listDrivers.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drivers list not found");
			return listDrivers;
		} catch (DriverServiceException e) {
			logger.log(Level.SEVERE, "Error to list Drivers");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Drivers list not found");
		}
	}

	
	@GetMapping("/api/drivers/{id}")
	public Driver getDriverById(@PathVariable Long id) {
		try {
			Driver driver = new Driver();
			driver = driverService.getDriverById(id);
			if (null == driver)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver not found id " + id);
			return driver;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error - Driver not found id " + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Driver not found" + id);
		}
	}

	@GetMapping("/api/drivers/{tag}")
	public Driver getDriverByTag(@PathVariable String tag) {
		try {
			Driver driver = new Driver();
			driver = driverService.getDriverByTag(tag);
			if (null == driver)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver not found tag " + tag);
			return driver;
		} catch (DriverServiceException e) {
			logger.log(Level.SEVERE, "Error - Driver not found id " + tag);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Driver not found" + tag);
		}
	}

	@DeleteMapping("/api/drivers/{id}")
	public void removeDriver(@PathVariable Long id) {
		try {
			driverService.removeDriver(id);
		} catch (DriverServiceException e) {
			logger.log(Level.SEVERE, "Error to delete driver id " + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to delete driver id" + id);
		}
	}

	@PostMapping("/api/drivers")
	public Driver addDriver(@RequestBody Driver driver) {
		try {
			return driverService.addDriver(driver);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to Add Driver");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to add driver");
		}
	}

	@PutMapping("/api/drivers")
	public Driver updateDriver(@RequestBody Driver driver) {
		try {
			return driverService.addDriver(driver);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to update Driver");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to update driver");
		}
	}

}
