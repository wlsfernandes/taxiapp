package com.asthon.taxi.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asthon.taxi.app.exception.CancelationReasonServiceException;
import com.asthon.taxi.app.model.CancelationReason;
import com.asthon.taxi.app.service.CancelationReasonService;

@RestController
public class CancelationReasonController {

	Logger logger = Logger.getLogger(CancelationReasonController.class.getName());

	@Autowired
	CancelationReasonService cancelationReasonService;

	@GetMapping("/api/cancelations")
	public List<CancelationReason> getAllCancelations() {
		try {
			List<CancelationReason> listCancelations = new ArrayList<CancelationReason>();
			listCancelations = cancelationReasonService.listCancelReasons();
			if (listCancelations.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "List of Cancelations not found");
			return listCancelations;
		} catch (CancelationReasonServiceException e) {
			logger.log(Level.SEVERE, "Error to get list of cancelations reasons");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to list Cancelations reasons");
		}
	}

	@GetMapping("/api/cancelations/{id}")
	public CancelationReason getOneCancelationReason(@PathVariable Long id) {
		try {
			return cancelationReasonService.getOne(id);
		} catch (CancelationReasonServiceException e) {
			logger.log(Level.SEVERE, "Error to get Cancelation Reason");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to get Cancelation Error" + id);
		}
	}

	@PostMapping("/api/cancelations")
	public CancelationReason add(@RequestBody CancelationReason cancelationReason) {
		try {
			return cancelationReasonService.add(cancelationReason);
		} catch (CancelationReasonServiceException e) {
			logger.log(Level.SEVERE, "Error to add Cancelation Reason");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to add Cancelation Error");
		}
	}

	@PutMapping("/api/cancelations")
	public CancelationReason update(@RequestBody CancelationReason cancelationReason) {
		try {
			return cancelationReasonService.update(cancelationReason);
		} catch (CancelationReasonServiceException e) {
			logger.log(Level.SEVERE, "Error to add Cancelation Reason");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to add Cancelation Error");
		}
	}

	@DeleteMapping("/api/cancelations/{id}")
	public void remove(@PathVariable Long id) {
		try {
			cancelationReasonService.removeCancelationReason(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to delete cancelationReason" + id);
		}
	}

}
