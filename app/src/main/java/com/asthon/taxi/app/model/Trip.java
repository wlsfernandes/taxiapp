package com.asthon.taxi.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import com.asthon.taxi.app.maps.model.Route;
import com.asthon.taxi.app.maps.model.Router;

import lombok.Data;

@Entity
@Data
@Table(name="trips")
public class Trip implements Serializable {

	private static final long serialVersionUID = -6284555259790961390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Cascade(CascadeType.SAVE_UPDATE)
	@OneToOne
	private Driver driver;
	@Cascade(CascadeType.SAVE_UPDATE)
	@OneToOne
	private User user;
	@OneToOne
	@Cascade(CascadeType.ALL)
	private TripStatus tripStatus;
	@OneToOne
	private CancelationReason cancelationReason;
	@OneToOne
	private Route route;
	
	@CreationTimestamp
	private LocalDateTime tripCreatedAt;

	private LocalDateTime tripAcceptTime;

	private LocalDateTime tripStartTime;

	private LocalDateTime tripFinishedAt;

	private String fromAddress;

	private String toAddress;
	
	private Double expectedfare;
	
	private Double expectedDistance;
	
	private String expectedDuration;
	
	private Double totalDistanceKm;
	
	private Double totalDistanceMile;

	private LocalTime totalDurationTime;
	
	private Double totalFare;
	
	private Double driverRating;

	private Float fuelUsed;
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TripStatus getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(TripStatus tripStatus) {
		this.tripStatus = tripStatus;
	}

	public CancelationReason getCancelationReason() {
		return cancelationReason;
	}

	public void setCancelationReason(CancelationReason cancelationReason) {
		this.cancelationReason = cancelationReason;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public LocalDateTime getTripCreatedAt() {
		return tripCreatedAt;
	}

	public void setTripCreatedAt(LocalDateTime tripCreatedAt) {
		this.tripCreatedAt = tripCreatedAt;
	}

	public LocalDateTime getTripAcceptTime() {
		return tripAcceptTime;
	}

	public void setTripAcceptTime(LocalDateTime tripAcceptTime) {
		this.tripAcceptTime = tripAcceptTime;
	}

	public LocalDateTime getTripStartTime() {
		return tripStartTime;
	}

	public void setTripStartTime(LocalDateTime tripStartTime) {
		this.tripStartTime = tripStartTime;
	}

	public LocalDateTime getTripFinishedAt() {
		return tripFinishedAt;
	}

	public void setTripFinishedAt(LocalDateTime tripFinishedAt) {
		this.tripFinishedAt = tripFinishedAt;
	}

	
	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public Double getExpectedfare() {
		return expectedfare;
	}

	public void setExpectedfare(Double expectedfare) {
		this.expectedfare = expectedfare;
	}

	public Double getExpectedDistance() {
		return expectedDistance;
	}

	public void setExpectedDistance(Double expectedDistance) {
		this.expectedDistance = expectedDistance;
	}

	public String getExpectedDuration() {
		return expectedDuration;
	}

	public void setExpectedDuration(String expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public Double getTotalDistanceKm() {
		return totalDistanceKm;
	}

	public void setTotalDistanceKm(Double totalDistanceKm) {
		this.totalDistanceKm = totalDistanceKm;
	}

	public Double getTotalDistanceMile() {
		return totalDistanceMile;
	}

	public void setTotalDistanceMile(Double totalDistanceMile) {
		this.totalDistanceMile = totalDistanceMile;
	}

	public LocalTime getTotalDurationTime() {
		return totalDurationTime;
	}

	public void setTotalDurationTime(LocalTime totalDurationTime) {
		this.totalDurationTime = totalDurationTime;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public Double getDriverRating() {
		return driverRating;
	}

	public void setDriverRating(Double driverRating) {
		this.driverRating = driverRating;
	}

	public Float getFuelUsed() {
		return fuelUsed;
	}

	public void setFuelUsed(Float fuelUsed) {
		this.fuelUsed = fuelUsed;
	}

	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
		
	

}
