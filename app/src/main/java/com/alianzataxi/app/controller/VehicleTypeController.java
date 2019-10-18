package com.alianzataxi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alianzataxi.app.model.VehicleType;
import com.alianzataxi.app.service.VehicleTypeService;

@RestController
public class VehicleTypeController {

	@Autowired
	VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicleTypes")
	public @ResponseBody List<VehicleType> getAllVehicleTypes() {
		return vehicleTypeService.getAllVehicleTypes();
	}

	/*
	 * @GetMapping("behiclesTypes/{id}") public VehicleType
	 * getVehicleType(@PathVariable Long id) { return
	 * vehicleTypeService.getVehicleType(id); }
	 */
}
