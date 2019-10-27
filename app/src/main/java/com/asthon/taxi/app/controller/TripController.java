package com.asthon.taxi.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asthon.taxi.app.exception.TripServiceException;
import com.asthon.taxi.app.model.Trip;
import com.asthon.taxi.app.service.TripService;

@RestController
public class TripController {

	Logger logger = Logger.getLogger(TripController.class.getName());

	@Autowired
	TripService tripService;

	@GetMapping("/api/trips")
	public List<Trip> findAllTrips() {
		try {
			List<Trip> listAllTrips = new ArrayList<Trip>();
			listAllTrips = tripService.getAllTrips();
			if (listAllTrips.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not Found");
			return listAllTrips;
		} catch (TripServiceException e) {
			logger.log(Level.SEVERE, " Error to find a Trip");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to find a trip");
		}
	}

	@GetMapping("/api/trips/user/{phoneNumber}")
	public Trip findTripByUserPhone(@PathVariable String phoneNumber) {
		try {
			Trip trip = new Trip();
			trip = tripService.getTripByUserPhone(phoneNumber);
			if (null == trip)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not Found");
			return trip;
		} catch (TripServiceException e) {
			logger.log(Level.SEVERE, " Error to find a Trip");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to find a trip");
		}
	}

	@PostMapping("/api/trips")
	public Trip addTrip(@RequestBody Trip trip) {
		try {
			return tripService.addTrip(trip);
		} catch (Exception e) {

			e.printStackTrace();
			return null;// TODO: handle exception
		}
	}
	
}
