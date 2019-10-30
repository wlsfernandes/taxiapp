package com.asthon.taxi.app.constructor;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asthon.taxi.app.maps.model.Router;
import com.asthon.taxi.app.model.Company;
import com.asthon.taxi.app.model.Trip;
import com.asthon.taxi.app.service.CompanyService;
import com.asthon.taxi.app.service.MapQuestService;

@Component
public class TripConstructor {

	@Autowired
	DriverConstructor driverConstructor;
	@Autowired
	MapQuestService mapQuestService;
	@Autowired
	CompanyService companyService;
	
	
	Logger logger = Logger.getLogger(TripConstructor.class.getName());

	public Trip settingUpTrip(Trip trip) {
		Router router = getTripRoute(trip);
		if (router != null) {
			Double expectedfare = calculateExpectedFare(trip, router);
			trip.setExpectedfare(expectedfare);
			trip.setExpectedDistance(router.getRoute().getDistance());
			trip.setExpectedDuration(router.getRoute().getFormattedTime());
			return trip;
		}
		trip.setDriver(driverConstructor.settingUpDriver(trip));
		trip.setTripAcceptTime(LocalDateTime.now());
		return trip;

	}

	public Router getTripRoute(Trip trip) {
		try {
			Router router = mapQuestService.getTripRouteByAddress(trip.getStartCoordinates().getNameOfLocation(),
					trip.getEndCoordinates().getNameOfLocation());
			return router;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to calculate route Trip ID" + trip.getId());
			return null;
		}

	}

	private Double calculateExpectedFare(Trip trip, Router router) {
		Company company = companyService.getOne(1l);
		Double expectedfare = (company.defaultBasicFare * router.getRoute().getDistance());
		if (expectedfare > company.getDefaultBasicFare())
			return expectedfare;
		else
			return company.getDefaultBasicFare();

	}

}
