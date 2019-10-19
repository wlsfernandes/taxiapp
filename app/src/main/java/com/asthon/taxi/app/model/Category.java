package com.asthon.taxi.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Category")
public class Category implements Serializable {

	
	private static final long serialVersionUID = -684507008861549645L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private Double farePerKm;
	
	private Double farePerMile;
	
	private Double farePerMinute;
	
	@CreationTimestamp
	private LocalDateTime createAt;
	
	@UpdateTimestamp
	private LocalDateTime updateAt;

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

	

	public Double getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(Double farePerKm) {
		this.farePerKm = farePerKm;
	}

	public Double getFarePerMile() {
		return farePerMile;
	}

	public void setFarePerMile(Double farePerMile) {
		this.farePerMile = farePerMile;
	}

	public Double getFarePerMinute() {
		return farePerMinute;
	}

	public void setFarePerMinute(Double farePerMinute) {
		this.farePerMinute = farePerMinute;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	


	public Category(Long id, String name, Double farePerKm, Double farePerMile, Double farePerMinute,
			LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.farePerKm = farePerKm;
		this.farePerMile = farePerMile;
		this.farePerMinute = farePerMinute;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Category() {
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	
	
	
	
	
	
}
