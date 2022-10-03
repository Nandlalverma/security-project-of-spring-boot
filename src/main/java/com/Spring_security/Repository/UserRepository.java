package com.Spring_security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring_security.Model.User;

public interface UserRepository extends JpaRepository<User, String> {

	
}
