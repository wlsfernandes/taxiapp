package com.asthon.taxi.app.constructor;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.asthon.taxi.app.model.Trip;
import com.asthon.taxi.app.service.TripService;

public class TripConstructor {

	@Autowired
	TripService tripService;
	@Autowired
	DriverConstructor driverConstructor;
	
	public Trip setTrip(Trip trip) {
		trip.setDriver(driverConstructor.setDriverToTrip(trip));
		trip.setTripAcceptTime(LocalDateTime.now());
		return trip;

	}

}
