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

import com.asthon.taxi.app.model.User;
import com.asthon.taxi.app.service.UserServiceImpl;

@RestController
public class UserController {

	Logger logger = Logger.getLogger(User.class.getName());

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/api/users")
	public List<User> getAllUsers() {
		try {
			List<User> listUsers = new ArrayList<User>();
			listUsers = userService.getAllUsers();
			if (listUsers.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return listUsers;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error to get all users");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error 2910");
		}

	}

	@GetMapping("/api//users/{id}")
	public User getUser(@PathVariable Long id) {
		try {
			User user = new User();
			user = userService.getUser(id);
			if (null == user)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return user;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error 2911 - Error to get User" + id);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/api/users")
	public User addUser(@RequestBody User user) {
		try {
			return userService.addUser(user);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error 2912 - Error to add User" );
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/api/users")
	public User updateUser(@RequestBody User user) {
		try {
			return userService.update(user);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error 2913 - Error to add User" );
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/api/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		try {
			userService.removeUser(id);	
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro 2914 - error to delete user");
		}
		
	}

}
