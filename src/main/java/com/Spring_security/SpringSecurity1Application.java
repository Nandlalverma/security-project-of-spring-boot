package com.Spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Spring_security.Model.User;
import com.Spring_security.Repository.UserRepository;

@SpringBootApplication
public class SpringSecurity1Application implements CommandLineRunner {

	@Autowired
	   private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity1Application.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {

		User user=new User();
		user.setEmail("abc@gmail.com");
		user.setUserName("nand");
		user.setPasswordName(this.bCryptPasswordEncoder.encode("abc"));
		user.setRole("NORMAL");
		this.userRepository.save(user);
		
		
		User user1=new User();
		user1.setEmail("roshani@gmail.com");
		user1.setUserName("roshani");
		user1.setPasswordName(this.bCryptPasswordEncoder.encode("xyz"));
		user1.setRole("ADMIN");
		this.userRepository.save(user1);
		
		
		
	}

}
