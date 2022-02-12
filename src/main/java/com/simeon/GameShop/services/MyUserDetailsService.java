package com.simeon.GameShop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simeon.GameShop.models.User;
import com.simeon.GameShop.models.UserPrincipal;
import com.simeon.GameShop.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired 
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final User user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + "User not found!");
		}
	
		return new UserPrincipal(user);
	}

}
