package com.alianzataxi.app.controller;

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

import com.alianzataxi.app.exception.CompanyServiceException;
import com.alianzataxi.app.model.Company;
import com.alianzataxi.app.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	CompanyService companyService;
	

	Logger logger = Logger.getLogger(Company.class.getName());

	@GetMapping("/api/companies")
	public List<Company> getAllCompanies() {
		try {
			List<Company> listCompanies = new ArrayList<Company>();
			listCompanies = companyService.getAllCompanies();
			if (listCompanies.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Companies not found");
			return listCompanies;
		} catch (CompanyServiceException e) {
			logger.log(Level.SEVERE, "Error 2901 - error list companies");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error 2901");
		}
	}

	@GetMapping("/api/companies/{id}")
	public Company getOne(@PathVariable Long id) {
		try {
			Company company = companyService.getOne(id);
			if (company == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company Not Found id =" + id);
			}
			return company;
		} catch (CompanyServiceException e) {
			logger.log(Level.SEVERE, "Error getOne Company " + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error 2902");
		}
		
	}

	@DeleteMapping("/api/companies/{id}")
	public void deleteCompany(@PathVariable Long id) {
		try {
			companyService.deleteCompany(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "error to delete company"+ id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/api/companies")
	public Company add(@RequestBody Company company) {
		
		try {
			return companyService.add(company);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "error to persist Company");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error 2903");
		}
		
	}
	
	@PutMapping("/api/companies")
	public Company update(@RequestBody Company company) {
		try {
			return companyService.updateCompany(company);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to update Company");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error 2904");
		}
	}
}
