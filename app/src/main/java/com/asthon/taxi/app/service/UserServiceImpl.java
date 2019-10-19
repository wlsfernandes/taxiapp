package com.asthon.taxi.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.asthon.taxi.app.model.Role;
import com.asthon.taxi.app.model.User;
import com.asthon.taxi.app.repository.RoleRepository;
import com.asthon.taxi.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<User> getAllUsers(){
		List<User> listUsers = new ArrayList<User>();
		userRepository.findAll().forEach(listUsers::add);
		return listUsers; 
	}
	
	public User getUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public void removeUser(Long id) {
		userRepository.deleteById(id);
	}
	
	@Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<Role>();
        roles= (Set<Role>) roleRepository.findAll();
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
