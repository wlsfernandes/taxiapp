package com.asthon.taxi.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asthon.taxi.app.exception.VehicleTypeServiceException;
import com.asthon.taxi.app.model.VehicleType;
import com.asthon.taxi.app.service.VehicleTypeService;

@RestController
public class VehicleTypeController {

	Logger logger = Logger.getLogger(VehicleTypeController.class.getName());

	@Autowired
	VehicleTypeService vehicleTypeService;

	@GetMapping("/api/vehicletypes")
	public List<VehicleType> getAllVehicleTypes() {
		try {
			List<VehicleType> listVehicleTypes = new ArrayList<VehicleType>();
			vehicleTypeService.getAllVehicleTypes().forEach(listVehicleTypes::add);
			if (listVehicleTypes.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicles not found");
			return listVehicleTypes;
		} catch (VehicleTypeServiceException e) {
			logger.log(Level.SEVERE, "Error to list Vehicles Types");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
		}

	}

	@GetMapping("/api/vehicletypes/{id}")
	public VehicleType getOne(Long id) {
		try {
			VehicleType vehicleType = vehicleTypeService.getOne(id);
			if (null == vehicleType)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle Type not found");
			return vehicleType;
		} catch (VehicleTypeServiceException e) {
			logger.log(Level.SEVERE, "Error to get Vehicles Type id " + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/api/vehicletypes")
	public VehicleType add(@RequestBody VehicleType vehicleType) {
		try {
			return vehicleTypeService.add(vehicleType);
		} catch (VehicleTypeServiceException e) {
			logger.log(Level.SEVERE, "Error to add Vehicle Type");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/api/vehicletypes")
	public VehicleType update(@RequestBody VehicleType vehicleType) {
		try {
			return vehicleTypeService.add(vehicleType);
		} catch (VehicleTypeServiceException e) {
			logger.log(Level.SEVERE, "Error to update Vehicle Type");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@DeleteMapping("/api/vehicletypes/{id}")
	public void remove(Long id) {
		try {
			vehicleTypeService.remove(id);
		} catch (VehicleTypeServiceException e) {
			logger.log(Level.SEVERE, "Error to remove Vehicle Type id " + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
