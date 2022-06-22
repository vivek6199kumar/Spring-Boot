package com.security.service;

import java.util.Optional;

import com.security.model.User;

public interface UserService {

	// 1.Method for save user
	public Integer saveUser(User user);
    
	//2. Method for find User by userName
	Optional<User> findByUsername(String username);

}
