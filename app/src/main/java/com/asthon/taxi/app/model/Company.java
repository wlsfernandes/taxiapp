package com.asthon.taxi.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Company implements Serializable{

	
	private static final long serialVersionUID = -5705155101352824315L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	public Long id;
	
	public String name;
	
	public Double fixedFarePerMinute;
	
	public String termsAndConditions;
	
	public String companyDetails;
	
	public Double defaultSearchDistance;
	
	public Double defaultBasicFare;
	
	public String hotline;
	
	@CreationTimestamp
	public LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFixedFarePerMinute() {
		return fixedFarePerMinute;
	}

	public void setFixedFarePerMinute(Double fixedFarePerMinute) {
		this.fixedFarePerMinute = fixedFarePerMinute;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public String getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(String companyDetails) {
		this.companyDetails = companyDetails;
	}

	public Double getDefaultSearchDistance() {
		return defaultSearchDistance;
	}

	public void setDefaultSearchDistance(Double defaultSearchDistance) {
		this.defaultSearchDistance = defaultSearchDistance;
	}

	public Double getDefaultBasicFare() {
		return defaultBasicFare;
	}

	public void setDefaultBasicFare(Double defaultBasicFare) {
		this.defaultBasicFare = defaultBasicFare;
	}

	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Company(Long id, String name, Double fixedFarePerMinute, String termsAndConditions, String companyDetails,
			Double defaultSearchDistance, Double defaultBasicFare, String hotline, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.fixedFarePerMinute = fixedFarePerMinute;
		this.termsAndConditions = termsAndConditions;
		this.companyDetails = companyDetails;
		this.defaultSearchDistance = defaultSearchDistance;
		this.defaultBasicFare = defaultBasicFare;
		this.hotline = hotline;
		this.createdAt = createdAt;
	}

	public Company() {
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
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
}
