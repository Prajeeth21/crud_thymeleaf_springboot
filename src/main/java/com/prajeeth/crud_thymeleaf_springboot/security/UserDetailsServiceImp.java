package com.prajeeth.crud_thymeleaf_springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prajeeth.crud_thymeleaf_springboot.model.User;
import com.prajeeth.crud_thymeleaf_springboot.repository.UserRepository;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Could not find User");
		}
		return new MyUserDetails(user);
	}


}
    
