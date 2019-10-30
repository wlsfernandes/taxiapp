package com.asthon.taxi.app.service;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.exception.MapServiceException;
import com.asthon.taxi.app.maps.model.Router;
import com.asthon.taxi.app.maps.util.MapUtil;

@Service
public class MapQuestService {

	Logger logger = Logger.getLogger(MapQuestService.class.getName());
	@Autowired
	MapUtil mapUtil;
	@Autowired
	Environment environment;
	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public Router getTripRouteByAddress(String from, String to) {
		try {
			String url = buildUrl(from, to);
			return getTripRoute(url);
		} catch (MapServiceException e) {
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
		} catch (MapServiceException e) {
			logger.log(Level.SEVERE, "Error to get Trip Route");
			// throw new MapServiceException("Route not found");
			return null;
		}
	}

	private String buildUrl(String from, String to) {
		try {
			String fromAddress = mapUtil.formatAddressToMap(from);
			String toAddress = mapUtil.formatAddressToMap(to);
			StringBuilder url = new StringBuilder();
			url.append(environment.getProperty("mapguest.api.url")).append("key=")
					.append(environment.getProperty("mapguest.api.key")).append("&from=").append(fromAddress)
					.append("&to=").append(toAddress).append("&outFormat=json&ambiguities=ignore")
					.append("&routeType=shortest").append("&doReverseGeocode=false").append("&enhancedNarrative=false")
					.append("&avoidTimedConditions=false");

			logger.info("Url to webservice  " + url.toString() + " => " + LocalDateTime.now());
			return url.toString();
		} catch (MapServiceException e) {
			logger.log(Level.SEVERE, "Error to buildUrl to WebService");
			return null;
			// throw new MapServiceException("Bad formation: Address not found");
		}
	}
}
