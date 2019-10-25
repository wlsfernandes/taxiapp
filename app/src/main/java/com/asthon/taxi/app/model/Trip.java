package com.asthon.taxi.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Trip implements Serializable {

	private static final long serialVersionUID = -6284555259790961390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Driver driver;
	@OneToOne
	private User user;
	@OneToOne
	private TripStatus tripStatus;
		
	@OneToOne
	private CancelationReason cancelationReason;
	
	private Double expectedfare;
	
	private Double expectedDistance;
	
	private Integer expectedDuration;
	
	private Double totalDistanceKm;
	
	private Double totalDistanceMile;

	private LocalTime totalDurationTime;
	
	private Double totalFare;
	
	private Double driverRating;

	
	
	
		
	
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

	public Integer getExpectedDuration() {
		return expectedDuration;
	}

	public void setExpectedDuration(Integer expectedDuration) {
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

	
	public Trip(Long id, Driver driver, User user, TripStatus tripStatus, CancelationReason cancelationReason,
			Double expectedfare, Double expectedDistance, Integer expectedDuration, Double totalDistanceKm,
			Double totalDistanceMile, LocalTime totalDurationTime, Double totalFare, Double driverRating) {
		super();
		this.id = id;
		this.driver = driver;
		this.user = user;
		this.tripStatus = tripStatus;
		this.cancelationReason = cancelationReason;
		this.expectedfare = expectedfare;
		this.expectedDistance = expectedDistance;
		this.expectedDuration = expectedDuration;
		this.totalDistanceKm = totalDistanceKm;
		this.totalDistanceMile = totalDistanceMile;
		this.totalDurationTime = totalDurationTime;
		this.totalFare = totalFare;
		this.driverRating = driverRating;
	}

	public Trip() {
		super();
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
