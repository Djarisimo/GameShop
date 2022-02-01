package com.simeon.GameShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simeon.GameShop.models.User;
import com.simeon.GameShop.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
        
        PasswordEncoder passwordEncoder;
	
	// Return all users
	public List<User> getUser(){
		return userRepository.findAll();
	}
        
        public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }
	
	// Save user
	public void save(User user) {
            String encodedPassword = this.passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
		userRepository.save(user);
	}
}
