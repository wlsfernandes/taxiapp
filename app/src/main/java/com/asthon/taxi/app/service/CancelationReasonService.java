package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.CancelationReason;
import com.asthon.taxi.app.repository.CancelatioReasonRepository;

@Service
public class CancelationReasonService {

	@Autowired
	CancelatioReasonRepository cancelationReasonRepository;

	public List<CancelationReason> listCancelReasons() {
		List<CancelationReason> list = new ArrayList<CancelationReason>();
		cancelationReasonRepository.findAll().forEach(list::add);
		return list;
	}

	public CancelationReason getOne(Long id) {
		return cancelationReasonRepository.findById(id).orElse(null);
	}

	public CancelationReason add(CancelationReason cancelationReason) {
		return cancelationReasonRepository.save(cancelationReason);
	}

	public CancelationReason update(CancelationReason cancelationReason) {
		return cancelationReasonRepository.save(cancelationReason);
	}

	public void removeCancelationReason(Long id) {
		cancelationReasonRepository.deleteById(id);
	}

}
