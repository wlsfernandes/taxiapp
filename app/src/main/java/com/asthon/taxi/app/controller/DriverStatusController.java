package com.asthon.taxi.app.controller;

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

import com.asthon.taxi.app.exception.DriverStatusServiceException;
import com.asthon.taxi.app.model.DriverStatus;
import com.asthon.taxi.app.service.DriverStatusService;

@RestController
public class DriverStatusController {

	Logger logger = Logger.getLogger(DriverStatusController.class.getName());
	@Autowired
	DriverStatusService driverStatusService;

	@GetMapping("/api/driverstatus")
	public List<DriverStatus> getAllDriverStatus() {
		try {
			List<DriverStatus> listStatus = new ArrayList<DriverStatus>();
			listStatus = driverStatusService.getAllDriverStatus();
			if (listStatus.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "List Drivers Status not found");
			return listStatus;
		} catch (DriverStatusServiceException e) {
			logger.log(Level.SEVERE, "Error to list Driver Status");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to list drivers status");
		}
	}

	@GetMapping("/api/driverstatus/{id}")
	public DriverStatus getOne(@PathVariable Long id) {
		try {
			DriverStatus driverStatus = new DriverStatus();
			driverStatus = driverStatusService.getOne(id);
			if (null == driverStatus)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver status not found");
			return driverStatus;
		} catch (DriverStatusServiceException e) {
			logger.log(Level.SEVERE, "Error to found driver status id " + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Driver status not found id " + id);
		}
	}

	@PostMapping("/api/driverstatus")
	public DriverStatus add(@RequestBody DriverStatus driverStatus) {
		try {
			return driverStatusService.add(driverStatus);
		} catch (DriverStatusServiceException e) {
			logger.log(Level.SEVERE, "Error to add a new Driver Status");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error to add new Driver Status");
		}
	}


	@PutMapping("/api/driverstatus")
	public DriverStatus update(@RequestBody DriverStatus driverStatus) {
		try {
			return driverStatusService.add(driverStatus);
		} catch (DriverStatusServiceException e) {
			logger.log(Level.SEVERE, "Error to add a new Driver Status");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error to add new Driver Status");
		}
	}

	@DeleteMapping("/api/driverstatus/{id}")
	public void remove(@PathVariable Long id) {
		try {
			driverStatusService.remove(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to remove Driver Status");
		}
	}
	
}
