package com.swagger.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.swagger.dao.UserRepository;
import com.swagger.model.User;
import com.swagger.service.UserSevcie;
@Service
public class UserServiceImpl implements UserSevcie{
    @Autowired
	private UserRepository repo;
    
    @Autowired
    private BCryptPasswordEncoder passEncoder;
	
    @Override
	public Integer userSave(User user) 
	{
    	
		user.setPassword(passEncoder.encode(user.getPassword()));
	return this.repo.save(user).getId();
	     	
	
	}

}
