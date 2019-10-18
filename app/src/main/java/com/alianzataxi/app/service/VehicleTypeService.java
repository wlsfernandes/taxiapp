package com.alianzataxi.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianzataxi.app.model.VehicleType;
import com.alianzataxi.app.repository.VehicleTypeRepository;

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


}
