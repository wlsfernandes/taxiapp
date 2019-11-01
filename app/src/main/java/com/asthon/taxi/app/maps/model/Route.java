package com.asthon.taxi.app.maps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "routes")
public class Route implements Serializable {

	private static final long serialVersionUID = -2550837592485247602L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Transient
	private boolean hasTollRoad;
	@Transient
	private boolean hasBridge;
	private Double distance;
	@Transient
	private boolean hasTimedRestriction;
	@Transient
	private boolean hasTunnel;
	@Transient
	private boolean hasHighway;
	private String formattedTime;
	@Transient
	private String sessionId;
	@Transient
	private boolean hasAccessRestriction;
	private float realTime;
	@Transient
	private boolean hasSeasonalClosure;
	@Transient
	private boolean hasCountryCross;
	@Transient
	private float fuelUsed;
	@OneToMany
	private List<Locations> locations = new ArrayList<Locations>();

	
	
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