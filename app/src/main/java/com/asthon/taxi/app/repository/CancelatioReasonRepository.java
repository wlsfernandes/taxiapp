package com.asthon.taxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.CancelationReason;

public interface CancelatioReasonRepository extends CrudRepository<CancelationReason, Long> {

}
