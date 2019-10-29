package com.asthon.taxi.app.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Router implements Serializable {

	private static final long serialVersionUID = 2192522605916092869L;
	Route RouteObject;

	 // Getter Methods 

	 public Route getRoute() {
	  return RouteObject;
	 }

	 // Setter Methods 

	 public void setRoute(Route routeObject) {
	  this.RouteObject = routeObject;
	 }
	}