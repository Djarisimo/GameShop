package com.simeon.GameShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simeon.GameShop.models.User;
import com.simeon.GameShop.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// Return all users
	public List<User> getUser(){
		return userRepository.findAll();
	}
	
	// Save user
	public void save(User user) {
		userRepository.save(user);
	}
}
