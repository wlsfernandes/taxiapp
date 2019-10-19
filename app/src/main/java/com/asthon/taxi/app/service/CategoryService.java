package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.Category;
import com.asthon.taxi.app.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		List<Category> listCategories = new ArrayList<Category>();
		categoryRepository.findAll().forEach(listCategories::add);
		return listCategories;

	}

	public Category getOne(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	public Category add(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category update(Category category) {
		return categoryRepository.save(category);
	}
	
	public void remove(Long id) {
		categoryRepository.deleteById(id);
	}
}
