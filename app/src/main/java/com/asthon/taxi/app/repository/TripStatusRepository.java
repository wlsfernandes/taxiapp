package com.asthon.taxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.TripStatus;

public interface TripStatusRepository extends CrudRepository<TripStatus, Long> {

}
