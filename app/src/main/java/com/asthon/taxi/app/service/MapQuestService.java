package com.asthon.taxi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.Router;

@Service
public class MapQuestService {

	@Autowired
	Environment environment;
	@Autowired
	RestTemplateBuilder restTemplateBuilder;

		
	public Router test(String from, String to) {
		String to2 = "4025+McGinnis+Ferry+Rd%2C+Suwanee%2C+GA";
				String from2 = "1000+Jimmy+Carter+Boulevard%2C+Norcross%2C+GA";
		try {
			StringBuilder url = new StringBuilder();
			 url.append(environment.getProperty("mapguest.api.url"))
			.append("key=").append(environment.getProperty("mapguest.api.key"))
			.append("&from=").append(from2)
			.append("&to=").append(to2)
			.append("&outFormat=json&ambiguities=ignore")
			.append("&routeType=fastest")
			.append("&doReverseGeocode=false")
			.append("&enhancedNarrative=false")
			.append("&avoidTimedConditions=false");
			 
			Router router = restTemplateBuilder.build().getForObject(url.toString(), Router.class);
			return router;
		} catch (Exception e) {
			return null;
		}
		
		/*
		 * String KEY = "n22W3NtbOBt35duFcGJWY8SSxLgHt3Me"; String url2 =
		 * "http://www.mapquestapi.com/directions/v2/route?key="+KEY+
		 * "&from=4025+McGinnis+Ferry+Rd%2C+Suwanee%2C+GA" +
		 * "&to=1000+Jimmy+Carter+Boulevard%2C+Norcross%2C+GA" +
		 * "&outFormat=json&ambiguities=ignore" + "&routeType=fastest" +
		 * "&doReverseGeocode=false" + "&enhancedNarrative=false" +
		 * "&avoidTimedConditions=false";
		 */
		
	}

}
