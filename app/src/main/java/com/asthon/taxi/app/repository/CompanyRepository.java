package com.asthon.taxi.app.repository;
import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.Company;
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
