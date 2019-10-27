package com.asthon.taxi.app.constructor;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asthon.taxi.app.model.Trip;

@Component
public class TripConstructor {


	@Autowired
	DriverConstructor driverConstructor;
	
	public Trip settingUpTrip(Trip trip) {
		trip.setDriver(driverConstructor.settingUpDriver(trip));
		trip.setTripAcceptTime(LocalDateTime.now());
		return trip;

	}

}
