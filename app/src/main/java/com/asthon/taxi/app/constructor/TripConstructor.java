package com.asthon.taxi.app.constructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asthon.taxi.app.maps.model.LatLng;
import com.asthon.taxi.app.maps.model.Locations;
import com.asthon.taxi.app.maps.model.Route;
import com.asthon.taxi.app.maps.model.Router;
import com.asthon.taxi.app.model.Company;
import com.asthon.taxi.app.model.Trip;
import com.asthon.taxi.app.service.CompanyService;
import com.asthon.taxi.app.service.LocationService;

@Component
public class TripConstructor {

	@Autowired
	DriverConstructor driverConstructor;
	@Autowired
	LocationService locationService;
	@Autowired
	CompanyService companyService;

	Logger logger = Logger.getLogger(TripConstructor.class.getName());

	public Trip settingUpTrip(Trip trip) {

		// find location from
		
		//if to find route
		Router router = getTripRouter(trip);

		if (router != null) {
			Route route = router.getRoute();
			trip.setRoute(route);

			calculateExpectedFare(trip, route);
			if (null != route.getDistance())
				trip.setExpectedDistance(route.getDistance());

			if (null != route.getFormattedTime())
				trip.setExpectedDuration(route.getFormattedTime());
			trip.setFuelUsed(route.getFuelUsed());
		}
		trip.setDriver(driverConstructor.settingUpDriver(trip));
		trip.setTripAcceptTime(LocalDateTime.now());
		return trip;

	}

	private Router getTripRouter(Trip trip) {
		try {
			Router router = locationService.getTripRouteByAddress(trip.getFromAddress(), trip.getToAddress());
			return router;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to calculate route Trip ID" + trip.getId());
			return null;
		}
	}

	private void calculateExpectedFare(Trip trip, Route route) {
		Company company = companyService.getOne(1l);
		Double expectedfare = (company.defaultBasicFare * route.getDistance() + company.getMinimumStartFare());
		if (expectedfare > company.getDefaultBasicFare())
			trip.setExpectedfare(expectedfare);
		else
			trip.setExpectedfare(company.getDefaultBasicFare());
	}

	private void setFromLatitudeLongitude(Trip trip, List<Locations> listLocations) {

		LatLng latitudeLongitude = new LatLng();
		if (!listLocations.isEmpty() && listLocations.size() > 0) {

			if (null != listLocations.get(0)) {
				Locations locations = new Locations();
				Double latitude = 0.00;
				Double longitude = 0.00;

				if (null != locations.getLatLng().getLat())
					latitude = locations.getLatLng().getLat();
				if (null != locations.getLatLng().getLng())
					longitude = locations.getLatLng().getLng();
				StringBuilder address = new StringBuilder();
				if (!locations.getStreet().isEmpty())
					address.append(locations.getStreet());
				if (!locations.getAdminArea5().isEmpty())
					address.append(locations.getAdminArea5());
				String nameOfLocation = address.toString();

				latitudeLongitude.setLat(latitude);
				latitudeLongitude.setLng(longitude);

			//	trip.setUser.se;(latitudeLongitude);
			}
		}
	}

	/*
	 * private void setTripTo(Trip trip, List<Locations> listLocations) {
	 * 
	 * Coordinates endCoordinates = new Coordinates();
	 * 
	 * if (!listLocations.isEmpty() && listLocations.size() > 0 &&
	 * listLocations.size() > 1) {
	 * 
	 * if (null != listLocations.get(1)) { Locations locations = new Locations();
	 * Double latitude = 0.00; Double longitude = 0.00;
	 * 
	 * if (null != locations.getLatLng().getLat()) latitude =
	 * locations.getLatLng().getLat(); if (null != locations.getLatLng().getLng())
	 * longitude = locations.getLatLng().getLng(); StringBuilder address = new
	 * StringBuilder(); if (!locations.getStreet().isEmpty())
	 * address.append(locations.getStreet()); if
	 * (!locations.getAdminArea5().isEmpty())
	 * address.append(locations.getAdminArea5()); String nameOfLocation =
	 * address.toString();
	 * 
	 * endCoordinates.setLatitude(latitude); endCoordinates.setLongitude(longitude);
	 * endCoordinates.setNameOfLocation(nameOfLocation);
	 * 
	 * trip.setEndCoordinates(endCoordinates); } } }
	 */
}
