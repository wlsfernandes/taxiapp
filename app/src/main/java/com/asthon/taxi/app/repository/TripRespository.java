package com.asthon.taxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.Trip;
import com.asthon.taxi.app.model.User;

public interface TripRespository extends CrudRepository<Trip, Long> {

	void findByUser(User user);

	Trip findByUserPhoneNumber(String phoneNumber);

}
