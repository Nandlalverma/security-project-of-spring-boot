package com.Spring_security.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String userName;
	private String password;
	private String email;
	private String role;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswordName() {
		return password;
	}
	public void setPasswordName(String passwordName) {
		this.password = passwordName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String userName, String passwordName, String email) {
		super();
		this.userName = userName;
		this.password = passwordName;
		this.email = email;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
