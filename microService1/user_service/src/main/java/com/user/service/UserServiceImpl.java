package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	
	//Fake User List
	List<User> list=List.of(
			new User(1311L,"Vivek Kumar","9113136053"),
			new User(1312L,"Bharat Kumar","9113136053"),
			new User(1313L,"Subodh Kumar","9113136053")
			
			
			);
	@Override
	public User getUser(Long id) {
	
		return this.list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
	}

}
