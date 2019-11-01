package com.asthon.taxi.app.service;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.exception.LocationServiceException;
import com.asthon.taxi.app.maps.model.GeoLocation;
import com.asthon.taxi.app.maps.model.LatLng;
import com.asthon.taxi.app.maps.model.Router;
import com.asthon.taxi.app.maps.util.MapUtil;

/*
 * WebService provided by 
 * MapQuest API
 * https://developer.mapquest.com/documentation/
 */
@Service
public class LocationService {

	private static final String MAP_API_ROUTER_URL = "http://www.mapquestapi.com/directions/v2/route?";
	private static final String MAP_API_GEOLOCATION_URL = "https://www.mapquestapi.com/geocoding/v1/address?";
	private static final String MAP_API_KEY = "n22W3NtbOBt35duFcGJWY8SSxLgHt3Me";

	Logger logger = Logger.getLogger(LocationService.class.getName());
	@Autowired
	MapUtil mapUtil;
	@Autowired
	Environment environment;
	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public GeoLocation getTripGeoLocationByAddress(String location) {
		try {
			String url = buildMapGeolocationUrl(location);
			return getTripGeoLocation(url);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to get Trip Route Address");
			throw new LocationServiceException("Trip Route not Found");
		}
	}

	public Router getTripRouteByAddress(String fromAddress, String toAddress) {
		try {
			String url = buildMapRouterUrl(fromAddress, toAddress);
			return getTripRoute(url);
		} catch (LocationServiceException e) {
			logger.log(Level.SEVERE, "Error to get Trip Route Address");
			return null;
			// throw new MapServiceException("Trip Route not Found");
		}
	}

	private Router getTripRoute(String url) {
		Router router = new Router();
		try {
			router = restTemplateBuilder.build().getForObject(url, Router.class);
			return router;
		} catch (LocationServiceException e) {
			logger.log(Level.SEVERE, "Error to get Trip Route");
			// throw new MapServiceException("Route not found");
			return null;
		}
	}

	private GeoLocation getTripGeoLocation(String url) {
		GeoLocation geoLocation = new GeoLocation();
		try {
			geoLocation = restTemplateBuilder.build().getForObject(url, GeoLocation.class);
			return geoLocation;
		} catch (LocationServiceException e) {
			logger.log(Level.SEVERE, "Error to get Trip GeoLocation");
			throw new LocationServiceException("Route not found");
		}
	}
	
	private String buildMapGeolocationUrl(String location) {

		try {
	
			String from = mapUtil.formatAddressToMap(location);
			StringBuilder url = new StringBuilder();

			url.append(MAP_API_GEOLOCATION_URL).append("key=").append(MAP_API_KEY).append("&inFormat=kvp")
					.append("&outFormat=json").append("&location=").append(from).append("&thumbMaps=false");
			
			logger.log(Level.INFO, "Url to get a location : " + url.toString());
			System.out.println("**************" + url.toString());
			return url.toString();
		
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to get a location ");
			throw new LocationServiceException("Bad formation: Address not found");
		}

	}

	private String buildMapRouterUrl(String fromAddress, String toAddress) {
		try {
			String from = mapUtil.formatAddressToMap(fromAddress);
			String to = mapUtil.formatAddressToMap(toAddress);
			StringBuilder url = new StringBuilder();
			url.append(MAP_API_ROUTER_URL).append("key=").append(MAP_API_KEY).append("&from=").append(from)
					.append("&to=").append(to).append("&outFormat=json&ambiguities=ignore")
					.append("&routeType=shortest").append("&doReverseGeocode=false").append("&enhancedNarrative=false")
					.append("&avoidTimedConditions=false");

			logger.info("Url to webservice  " + url.toString() + " => " + LocalDateTime.now());
			return url.toString();
		} catch (LocationServiceException e) {
			logger.log(Level.SEVERE, "Error to buildUrl to WebService");
			return null;
			// throw new MapServiceException("Bad formation: Address not found");
		}
	}

	public double getDistanceBetweenCoordinates(LatLng initialPoint, LatLng target, String unit) {

		Double lon1, lon2, lat1, lat2 = 0.0;
		lon1 = Math.toRadians(initialPoint.getLng());
		lon2 = Math.toRadians(target.getLng());
		lat1 = Math.toRadians(initialPoint.getLat());
		lat2 = Math.toRadians(target.getLat());
		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		// Radius of earth in kilometers. Use 3956 for miles
		double r = 3956;
		if (unit.equals("k"))
			r = 6371;
		// calculate the result
		return (c * r);
	}
}
