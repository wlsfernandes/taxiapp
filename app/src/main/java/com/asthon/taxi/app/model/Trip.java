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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
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
	
	@CreationTimestamp
	private LocalDateTime tripCreatedAt;

	private LocalDateTime tripAcceptTime;

	private LocalDateTime tripStartTime;

	private LocalDateTime tripFinishedAt;
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Coordinates startCoordinates;
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Coordinates currentCoordinates;
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Coordinates endCoordinates;
	
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

	public Coordinates getStartCoordinates() {
		return startCoordinates;
	}

	public void setStartCoordinates(Coordinates startCoordinates) {
		this.startCoordinates = startCoordinates;
	}

	public Coordinates getCurrentCoordinates() {
		return currentCoordinates;
	}

	public void setCurrentCoordinates(Coordinates currentCoordinates) {
		this.currentCoordinates = currentCoordinates;
	}

	public Coordinates getEndCoordinates() {
		return endCoordinates;
	}

	public void setEndCoordinates(Coordinates endCoordinates) {
		this.endCoordinates = endCoordinates;
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
			LocalDateTime tripCreatedAt, LocalDateTime tripAcceptTime, LocalDateTime tripStartTime,
			LocalDateTime tripFinishedAt, Coordinates startCoordinates, Coordinates currentCoordinates,
			Coordinates endCoordinates, Double expectedfare, Double expectedDistance, Integer expectedDuration,
			Double totalDistanceKm, Double totalDistanceMile, LocalTime totalDurationTime, Double totalFare,
			Double driverRating) {
		super();
		this.id = id;
		this.driver = driver;
		this.user = user;
		this.tripStatus = tripStatus;
		this.cancelationReason = cancelationReason;
		this.tripCreatedAt = tripCreatedAt;
		this.tripAcceptTime = tripAcceptTime;
		this.tripStartTime = tripStartTime;
		this.tripFinishedAt = tripFinishedAt;
		this.startCoordinates = startCoordinates;
		this.currentCoordinates = currentCoordinates;
		this.endCoordinates = endCoordinates;
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
