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

import com.asthon.taxi.app.exception.CategoryServiceException;
import com.asthon.taxi.app.model.Category;
import com.asthon.taxi.app.service.CategoryService;

@RestController
public class CategoryController {

	Logger logger = Logger.getLogger(CategoryController.class.getName());

	@Autowired
	CategoryService categoryService;

	@GetMapping("/api/categories")
	public List<Category> getAllCategories() {
		try {
			List<Category> listCategories = new ArrayList<Category>();
			listCategories = categoryService.getAllCategories();
			if (listCategories.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return listCategories;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to get all categories");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/api/categories/{id}")
	public Category getOne(@PathVariable Long id) {
		try {
			Category category = new Category();
			category = categoryService.getOne(id);
			if (null == category)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return category;
		} catch (CategoryServiceException e) {
			logger.log(Level.SEVERE, "Error to get category id " + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/api/categories")
	public Category add(@RequestBody Category category) {
		try {
			return categoryService.add(category);
		} catch (CategoryServiceException e) {
			logger.log(Level.SEVERE, "Error to add category");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/api/categories")
	public Category update(@RequestBody Category category) {
		try {
			return categoryService.add(category);
		} catch (CategoryServiceException e) {
			logger.log(Level.SEVERE, "Error to add category");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/api/categories/{id}")
	public void remove(@PathVariable Long id) {
		try {
			categoryService.remove(id);
		} catch (CategoryServiceException e) {
			logger.log(Level.SEVERE, "Error to remove category");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
