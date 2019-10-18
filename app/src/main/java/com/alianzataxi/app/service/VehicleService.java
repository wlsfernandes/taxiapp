package com.alianzataxi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianzataxi.app.model.Vehicle;
import com.alianzataxi.app.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	public List<Vehicle> getAllVehicles() {
		List<Vehicle> listVehicles = new ArrayList<Vehicle>();
		vehicleRepository.findAll().forEach(listVehicles::add);
		return listVehicles;
	}

	public Vehicle getOne(Long id) {
		return vehicleRepository.findById(id).orElse(null);
	}

	public Vehicle add(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public Vehicle update(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public void remove(Long id) {
		vehicleRepository.deleteById(id);
	}
}
