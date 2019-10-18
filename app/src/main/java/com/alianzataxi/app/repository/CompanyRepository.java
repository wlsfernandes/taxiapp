package com.alianzataxi.app.repository;
import org.springframework.data.repository.CrudRepository;

import com.alianzataxi.app.model.Company;
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
