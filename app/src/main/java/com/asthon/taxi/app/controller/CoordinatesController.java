package com.asthon.taxi.app.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asthon.taxi.app.model.Coordinates;
import com.asthon.taxi.app.service.CoordinatesService;

@RestController
public class CoordinatesController {

	Logger logger = Logger.getLogger(CoordinatesController.class.getName());

	@Autowired
	CoordinatesService coordinatesService;

	public Coordinates getOneCoordinate(Long id) {
		try {
			Coordinates coordinates = new Coordinates();
			coordinates = coordinatesService.getCoordinates(id);
			if (null == coordinates)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordinates not found");
			return coordinates;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to get Coordinate");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Coordinates not found");
		}
	}

	
	
}
