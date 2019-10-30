package com.asthon.taxi.app.maps.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.asthon.taxi.app.exception.MapServiceException;

@Component
public class MapUtil {

	Logger logger = Logger.getLogger(MapUtil.class.getName());
	/*
	 * Remove spaces commas and replace by plus signal 
	 */
	public String formatAddressToMap(String address) throws MapServiceException {
		try {
			String formattedAddress = new String();
			formattedAddress = address.trim().replaceAll(",", " ").replaceAll("\\s+", "+");
			return formattedAddress;
		} catch (Exception e) {
			logger.log(Level.WARNING,"String address baf formation" + address);
			return null;
		}
	}
}