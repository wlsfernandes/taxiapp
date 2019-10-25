package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.Driver;
import com.asthon.taxi.app.model.Trip;
import com.asthon.taxi.app.model.User;
import com.asthon.taxi.app.repository.TripRespository;

@Service
public class TripService {

	@Autowired
	TripRespository tripRespository;
	@Autowired
	DriverService driverService;
	
	public List<Trip> getAllTrips(){
		List<Trip> listAllTrips = new ArrayList<Trip>();
		tripRespository.findAll().forEach(listAllTrips::add);
		return listAllTrips;
	}
	
	public List<Trip> listTripsByUser(User user) {
		List<Trip> listTrips = new ArrayList<Trip>();
		tripRespository.findByUser(user);
		return listTrips;
	}

	public Trip getTripByUserPhone(String phoneNumber) {
		Trip trip = new Trip();
		trip = tripRespository.findByUserPhoneNumber(phoneNumber);
		return trip;
	}

	public Trip addTrip(Trip trip) {
		try {
			if ( trip.getDriver() == null ) {
				Driver driver = new Driver();
				driver = driverService.findNearFreeDriver(trip.getTripStatus().getStartCoordinates());
				if ( driver != null ) {
					trip.setDriver(driver);
					return tripRespository.save(trip);
				}
					
			}
	
			
		} catch (Exception e) {
		}
		return tripRespository.save(trip);
	}

	
	public Trip updateTrip(Trip trip) {
		return tripRespository.save(trip);
	}

	
	
}
