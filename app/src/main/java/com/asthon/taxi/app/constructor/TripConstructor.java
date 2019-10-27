package com.asthon.taxi.app.constructor;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asthon.taxi.app.model.Trip;

@Component
public class TripConstructor {


	@Autowired
	DriverConstructor driverConstructor;
	
	public Trip setTrip(Trip trip) {
		trip.setDriver(driverConstructor.setDriverToTrip(trip));
		trip.setTripAcceptTime(LocalDateTime.now());
		return trip;

	}

}
