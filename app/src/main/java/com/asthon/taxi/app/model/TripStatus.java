package com.asthon.taxi.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class TripStatus implements Serializable {

	private static final long serialVersionUID = 1430212454545432159L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	private LocalDateTime tripCreatedAt;

	private LocalDateTime tripAcceptTime;

	private LocalDateTime tripStartTime;

	private LocalDateTime tripFinishedAt;

	@OneToOne
	private Coordinates startCoordinates;

	@OneToOne
	private Coordinates currentCoordinates;

	@OneToOne
	private Coordinates endCoordinates;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TripStatus(Long id, LocalDateTime tripCreatedAt, LocalDateTime tripAcceptTime, LocalDateTime tripStartTime,
			LocalDateTime tripFinishedAt, Coordinates startCoordinates, Coordinates currentCoordinates,
			Coordinates endCoordinates) {
		super();
		this.id = id;
		this.tripCreatedAt = tripCreatedAt;
		this.tripAcceptTime = tripAcceptTime;
		this.tripStartTime = tripStartTime;
		this.tripFinishedAt = tripFinishedAt;
		this.startCoordinates = startCoordinates;
		this.currentCoordinates = currentCoordinates;
		this.endCoordinates = endCoordinates;
	}

	public TripStatus() {
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
		TripStatus other = (TripStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
