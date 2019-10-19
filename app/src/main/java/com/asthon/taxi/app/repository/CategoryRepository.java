package com.asthon.taxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
