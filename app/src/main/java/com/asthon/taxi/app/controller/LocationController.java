package com.asthon.taxi.app.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asthon.taxi.app.maps.model.GeoLocation;
import com.asthon.taxi.app.maps.model.Router;
import com.asthon.taxi.app.service.LocationService;

@RestController
public class LocationController implements Serializable {

	private static final long serialVersionUID = -2851697473206562823L;

	@Autowired
	LocationService locationService;

	@GetMapping("/api/location/geolocation/{location}")
	public GeoLocation getRoute(@PathVariable String location) {
		return locationService.getTripGeoLocationByAddress(location);
	}
	
	@GetMapping("/api/location/route/{startLocation}/{endLocation}")
	public Router getRoute(@PathVariable String startLocation, @PathVariable String endLocation) {
		return locationService.getTripRouteByAddress(startLocation, endLocation);
	}

	
}
