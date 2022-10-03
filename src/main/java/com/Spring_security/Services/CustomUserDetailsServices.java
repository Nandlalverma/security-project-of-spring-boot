package com.Spring_security.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Spring_security.Model.User;
import com.Spring_security.Repository.UserRepository;

@Service
public class CustomUserDetailsServices implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          
		User user=this.userRepository.getById(username);
		if(user==null) {
			throw new UsernameNotFoundException("NO User");
		}
		return new CustomUserDetailsService();
	}

}
