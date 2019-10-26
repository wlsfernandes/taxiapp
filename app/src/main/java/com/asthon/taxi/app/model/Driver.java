package com.asthon.taxi.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="drivers")
public class Driver implements Serializable {

	private static final long serialVersionUID = 2665379669088934847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tag;
	
	@OneToOne
	private User user;
	
	@OneToMany
	private List<Vehicle> vehicles;
	
	private Boolean isOnline;
	
	private Boolean isActive;
	
	private Double rating;
	
	private Boolean isVerified;
	
    @Enumerated(EnumType.STRING)
	private DriverStatus driverStatus;
	
	@CreationTimestamp
	private LocalDateTime createAt;
	
	private LocalDateTime lastLoginAt;

	private Coordinates currentCoordinates;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public DriverStatus getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(DriverStatus driverStatus) {
		this.driverStatus = driverStatus;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(LocalDateTime lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public Coordinates getCurrentCoordinates() {
		return currentCoordinates;
	}

	public void setCurrentCoordinates(Coordinates currentCoordinates) {
		this.currentCoordinates = currentCoordinates;
	}

	public Driver() {
	}

	
	
	public Driver(Long id, String tag, User user, List<Vehicle> vehicles, Boolean isOnline, Boolean isActive,
			Double rating, Boolean isVerified, DriverStatus driverStatus, LocalDateTime createAt,
			LocalDateTime lastLoginAt, Coordinates currentCoordinates) {
		super();
		this.id = id;
		this.tag = tag;
		this.user = user;
		this.vehicles = vehicles;
		this.isOnline = isOnline;
		this.isActive = isActive;
		this.rating = rating;
		this.isVerified = isVerified;
		this.driverStatus = driverStatus;
		this.createAt = createAt;
		this.lastLoginAt = lastLoginAt;
		this.currentCoordinates = currentCoordinates;
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
		Driver other = (Driver) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
