package com.alianzataxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.alianzataxi.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
