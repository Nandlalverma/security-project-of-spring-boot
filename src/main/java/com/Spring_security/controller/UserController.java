package com.Spring_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring_security.Model.User;
import com.Spring_security.Services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserServices userServices;
	
	
	// all users
	@GetMapping("/")
	public List<User> getAllUser(){
		return this.userServices.getAllUser();
	}
	
	
	//get user
	//@PreAuthorize("hasRole('ADMIN')")  // access the user only admin 
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String userName) {
		return this.userServices.getUser(userName);
	}
	
	
	// add user
	@PostMapping("/user")
	public User addUser(@RequestBody User userName) {
		return this.userServices.addUser(userName);
	}
	
}
