package com.alianzataxi.app.controller;

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

import com.alianzataxi.app.model.Vehicle;
import com.alianzataxi.app.service.VehicleService;

@RestController
public class VehicleController {

	Logger logger = Logger.getLogger(VehicleController.class.getName());

	@Autowired
	VehicleService vehicleService;

	@GetMapping("/api/vehicles")
	public List<Vehicle> getAllVehicles() {
		try {
			List<Vehicle> listVehicles = new ArrayList<Vehicle>();
			listVehicles = vehicleService.getAllVehicles();
			if (null == listVehicles)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return listVehicles;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error 2921 - Error get list Vehicles");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error 2921");
		}

	}

	@GetMapping("/api/vehicles/{id}")
	public Vehicle getOne(@PathVariable Long id) {
		try {
			Vehicle vehicle = new Vehicle();
			vehicle = vehicleService.getOne(id);
			if (null == vehicle)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return vehicle;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error 2922 - Error to get Vehicle");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error 2922");
		}

	}

	@PostMapping("/api/vehicles")
	public Vehicle add(@RequestBody Vehicle vehicle) {
		try {
			return vehicleService.add(vehicle);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error 2923 - Error to add a vehicle");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, " Error 2923");
		}
	}

	@PutMapping("/api/vehicles")
	public Vehicle update(@RequestBody Vehicle vehicle) {
		try {
			return vehicleService.add(vehicle);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error 2924 - Error to UPDATE a vehicle");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, " Error 2924");
		}
	}

	@DeleteMapping("/api/vehicles/{id}")
	public void delete(Long id) {
		try {
			vehicleService.remove(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error 2925 - Error to delete Vehicle" + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error 2925 - Error to remove Vehicle" + id);
		}
	}

}
j