package com.asthon.taxi.app.maps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Route implements Serializable {
  
 private static final long serialVersionUID = -2550837592485247602L;

  private boolean hasTollRoad;
  private boolean hasBridge;
  BoundingBox BoundingBoxObject;
  private Double distance;
  private boolean hasTimedRestriction;
  private boolean hasTunnel;
  private boolean hasHighway;
	/*
	 * ArrayList<Object> computedWaypoints = new ArrayList<Object>(); RouteError
	 * RouteErrorObject;
	 */
  private String formattedTime;
  private String sessionId;
  private boolean hasAccessRestriction;
  private float realTime;
  private boolean hasSeasonalClosure;
  private boolean hasCountryCross;
  private float fuelUsed;
  List<Locations> locations = new ArrayList<Locations>();
  
  
  
public boolean isHasTollRoad() {
	return hasTollRoad;
}
public void setHasTollRoad(boolean hasTollRoad) {
	this.hasTollRoad = hasTollRoad;
}
public boolean isHasBridge() {
	return hasBridge;
}
public void setHasBridge(boolean hasBridge) {
	this.hasBridge = hasBridge;
}
public BoundingBox getBoundingBoxObject() {
	return BoundingBoxObject;
}
public void setBoundingBoxObject(BoundingBox boundingBoxObject) {
	BoundingBoxObject = boundingBoxObject;
}
public Double getDistance() {
	return distance;
}
public void setDistance(Double distance) {
	this.distance = distance;
}
public boolean isHasTimedRestriction() {
	return hasTimedRestriction;
}
public void setHasTimedRestriction(boolean hasTimedRestriction) {
	this.hasTimedRestriction = hasTimedRestriction;
}
public boolean isHasTunnel() {
	return hasTunnel;
}
public void setHasTunnel(boolean hasTunnel) {
	this.hasTunnel = hasTunnel;
}
public boolean isHasHighway() {
	return hasHighway;
}
public void setHasHighway(boolean hasHighway) {
	this.hasHighway = hasHighway;
}

	/*
	 * public ArrayList<Object> getComputedWaypoints() { return computedWaypoints; }
	 * public void setComputedWaypoints(ArrayList<Object> computedWaypoints) {
	 * this.computedWaypoints = computedWaypoints; } public RouteError
	 * getRouteErrorObject() { return RouteErrorObject; } public void
	 * setRouteErrorObject(RouteError routeErrorObject) { RouteErrorObject =
	 * routeErrorObject; }
	 */
public String getFormattedTime() {
	return formattedTime;
}
public void setFormattedTime(String formattedTime) {
	this.formattedTime = formattedTime;
}
public String getSessionId() {
	return sessionId;
}
public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
}
public boolean isHasAccessRestriction() {
	return hasAccessRestriction;
}
public void setHasAccessRestriction(boolean hasAccessRestriction) {
	this.hasAccessRestriction = hasAccessRestriction;
}
public float getRealTime() {
	return realTime;
}
public void setRealTime(float realTime) {
	this.realTime = realTime;
}
public boolean isHasSeasonalClosure() {
	return hasSeasonalClosure;
}
public void setHasSeasonalClosure(boolean hasSeasonalClosure) {
	this.hasSeasonalClosure = hasSeasonalClosure;
}
public boolean isHasCountryCross() {
	return hasCountryCross;
}
public void setHasCountryCross(boolean hasCountryCross) {
	this.hasCountryCross = hasCountryCross;
}
public float getFuelUsed() {
	return fuelUsed;
}
public void setFuelUsed(float fuelUsed) {
	this.fuelUsed = fuelUsed;
}

public List<Locations> getLocations() {
	return locations;
}
public void setLocations(List<Locations> locations) {
	this.locations = locations;
}




public Route() {
	super();
	// TODO Auto-generated constructor stub
}

  
  
  
}