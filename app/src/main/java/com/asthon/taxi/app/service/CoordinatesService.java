package com.asthon.taxi.app.service;

import java.awt.geom.Point2D;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.Coordinates;

@Service
public class CoordinatesService {

	@Autowired
	CoordinatesRepository coordinatesRepository;

	public Coordinates getCoordinates(Long id) {
		return coordinatesRepository.findById(id).orElse(null);
	}

	public Coordinates addCoordinates(Coordinates coordinates) {
		return coordinatesRepository.save(coordinates);
	}

	public Coordinates updateCoordinates(Coordinates coordinates) {
		return coordinatesRepository.save(coordinates);
	}

	public void removeCoordinates(Long id) {
		coordinatesRepository.deleteById(id);
	}

	/*
	 * ESRI corporation regularly use X as longitude and Y as latitude. The reason
	 * behind is: If you place x and y axis on earth, Latitude will cut across y
	 * axis and Longitude will cut across x axis. Hence, Latitude is y and Longitude
	 * is x
	 */
	public double getDistanceBetweenCoordinates(Coordinates initialPoint, Coordinates target, String unit) {

		Double lon1, lon2, lat1, lat2 = 0.0;
		lon1 = Math.toRadians(initialPoint.getLongitude());
		lon2 = Math.toRadians(target.getLongitude());
		lat1 = Math.toRadians(initialPoint.getLatitude());
		lat2 = Math.toRadians(target.getLatitude());
        // Haversine formula  
        double dlon = lon2 - lon1;  
        double dlat = lat2 - lat1; 
        double a = Math.pow(Math.sin(dlat / 2), 2) 
                 + Math.cos(lat1) * Math.cos(lat2) 
                 * Math.pow(Math.sin(dlon / 2),2); 
        double c = 2 * Math.asin(Math.sqrt(a)); 
     // Radius of earth in kilometers. Use 3956 for miles 
        double r = 3956;
        if (unit.equals("k"))
        	r = 6371;
        // calculate the result 
        return(c * r); 
	}
}
