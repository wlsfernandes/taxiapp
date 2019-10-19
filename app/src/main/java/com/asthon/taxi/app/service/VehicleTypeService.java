package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.VehicleType;
import com.asthon.taxi.app.repository.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	VehicleTypeRepository vehicleTypeRepository;

	Logger logger = Logger.getLogger(VehicleTypeService.class.getName());

	public List<VehicleType> getAllVehicleTypes() {
		List<VehicleType> listVehiculeTypes = new ArrayList<VehicleType>();
		try {
			vehicleTypeRepository.findAll().forEach(listVehiculeTypes::add);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "VehicleTypeService");
		}
		return listVehiculeTypes;
	}

	public VehicleType getOne(Long id) {
		return vehicleTypeRepository.findById(id).orElse(null);
	}

	public VehicleType add(VehicleType vehicleType) {
		return vehicleTypeRepository.save(vehicleType);
	}

	public VehicleType update(VehicleType vehicleType) {
		return vehicleTypeRepository.save(vehicleType);
	}

	public void remove(Long id) {
		vehicleTypeRepository.deleteById(id);
	}
}
