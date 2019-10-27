package com.asthon.taxi.app.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asthon.taxi.app.model.Driver;
import com.asthon.taxi.app.model.DriverStatus;
import com.asthon.taxi.app.model.Trip;
import com.asthon.taxi.app.service.DriverService;

@Component
public class DriverConstructor {

	@Autowired
	DriverService driverService;

	public Driver settingUpDriver(Trip trip) {
		Driver driver = new Driver();
		driver = driverService.searchFreeDriver(trip);
		driver.setDriverStatus(DriverStatus.OCCUPIED);
		return driver;
	}
}
