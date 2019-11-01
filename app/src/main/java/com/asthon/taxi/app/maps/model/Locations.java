package com.asthon.taxi.app.maps.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations implements Serializable {

	private static final long serialVersionUID = -1514907189369507294L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private LatLng latLng;
	private String street;
	private String adminArea5;
	private String adminArea4;
	private String postalCode;
	private String adminArea1;
	private String adminArea3;
	private String type;
	private String sideOfStreet;
	private String geocodeQualityCode;
	private String adminArea4Type;
	private float linkId;
	private String adminArea5Type;
	private String geocodeQuality;
	private String adminArea1Type;
	private String adminArea3Type;

	public LatLng getLatLng() {
		return latLng;
	}

	public void setLatLng(LatLng latLng) {
		this.latLng = latLng;
	}

	public String getAdminArea4() {
		return adminArea4;
	}

	public void setAdminArea4(String adminArea4) {
		this.adminArea4 = adminArea4;
	}

	public String getAdminArea5() {
		return adminArea5;
	}

	public void setAdminArea5(String adminArea5) {
		this.adminArea5 = adminArea5;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAdminArea1() {
		return adminArea1;
	}

	public void setAdminArea1(String adminArea1) {
		this.adminArea1 = adminArea1;
	}

	public String getAdminArea3() {
		return adminArea3;
	}

	public void setAdminArea3(String adminArea3) {
		this.adminArea3 = adminArea3;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSideOfStreet() {
		return sideOfStreet;
	}

	public void setSideOfStreet(String sideOfStreet) {
		this.sideOfStreet = sideOfStreet;
	}

	public String getGeocodeQualityCode() {
		return geocodeQualityCode;
	}

	public void setGeocodeQualityCode(String geocodeQualityCode) {
		this.geocodeQualityCode = geocodeQualityCode;
	}

	public String getAdminArea4Type() {
		return adminArea4Type;
	}

	public void setAdminArea4Type(String adminArea4Type) {
		this.adminArea4Type = adminArea4Type;
	}

	public float getLinkId() {
		return linkId;
	}

	public void setLinkId(float linkId) {
		this.linkId = linkId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAdminArea5Type() {
		return adminArea5Type;
	}

	public void setAdminArea5Type(String adminArea5Type) {
		this.adminArea5Type = adminArea5Type;
	}

	public String getGeocodeQuality() {
		return geocodeQuality;
	}

	public void setGeocodeQuality(String geocodeQuality) {
		this.geocodeQuality = geocodeQuality;
	}

	public String getAdminArea1Type() {
		return adminArea1Type;
	}

	public void setAdminArea1Type(String adminArea1Type) {
		this.adminArea1Type = adminArea1Type;
	}

	public String getAdminArea3Type() {
		return adminArea3Type;
	}

	public void setAdminArea3Type(String adminArea3Type) {
		this.adminArea3Type = adminArea3Type;
	}

}
