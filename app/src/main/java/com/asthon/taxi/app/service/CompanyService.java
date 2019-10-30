package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.asthon.taxi.app.model.Company;
import com.asthon.taxi.app.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public List<Company> getAllCompanies() {
			List<Company> listCompanies = new ArrayList<Company>();
			companyRepository.findAll().forEach(listCompanies::add);
			return listCompanies;
	}

	public Company getOne(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	public Company add(Company company) {
		return companyRepository.save(company);
	}

	public Company updateCompany(Company company) {
		return companyRepository.save(company);
	}

	public void deleteCompany(Long id) {
		companyRepository.deleteById(id);
	}
	
}
