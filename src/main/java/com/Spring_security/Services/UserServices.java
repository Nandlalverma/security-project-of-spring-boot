package com.Spring_security.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Spring_security.Model.User;

@Service
public class UserServices {

	   List<User> list=new ArrayList<>();
	   public UserServices() {
		   
		   list.add(new User("abc","abc","abc@gmail.com"));
		   list.add(new User("cat","cat","cat@gmail.com"));
		   list.add(new User("dog","dog","dog@gmail.com"));
	   }
	   
	   // getAll user
	   public List<User> getAllUser(){
		   return this.list;
	   }
	   
	   // get user
	   public User getUser(String user) {
		   return this.list.stream().filter(u->u.getUserName()
				   .equals(user)).findAny().orElse(null);
	   }
	   
	   // add user
	   public User addUser(User user) {
		   this.list.add(user);
		   return user;
	   }
	   
	   
}
