package com.swagger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swagger.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
	//CUSTOMIZED METHOD
	public User findByUsername(String username);

}
