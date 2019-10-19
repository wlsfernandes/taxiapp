package com.asthon.taxi.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.asthon.taxi.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
