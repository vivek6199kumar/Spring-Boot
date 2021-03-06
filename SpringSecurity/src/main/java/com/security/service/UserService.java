package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.dao.UserRepository;
import com.security.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void addUserLoginPassword(User user) {

		System.out.println("hello ++++" + user);
		System.out.println(user.getUsername());
		User u1 = new User();
		u1.setUserName(user.getUserName());
		u1.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		u1.setRole(user.getRole());
		u1.setEmail(user.getEmail());
		this.UserRepository.save(u1);
		System.out.println("User Login and Password Details" + u1);
	}

}
