package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.DriverStatus;
import com.asthon.taxi.app.repository.DriverStatusRepository;

@Service
public class DriverStatusService {

	@Autowired
	DriverStatusRepository driverStatusRepository;

	public List<DriverStatus> getAllDriverStatus() {
		List<DriverStatus> listStatus = new ArrayList<DriverStatus>();
		driverStatusRepository.findAll().forEach(listStatus::add);
		return listStatus;
	}

	public DriverStatus getOne(Long id) {
		return driverStatusRepository.findById(id).orElse(null);
	}

	public DriverStatus add(DriverStatus driverStatus) {
		return driverStatusRepository.save(driverStatus);
	}

	public DriverStatus update(DriverStatus driverStatus) {
		return driverStatusRepository.save(driverStatus);
	}

	public void remove(Long id) {
		driverStatusRepository.deleteById(id);
	}

}