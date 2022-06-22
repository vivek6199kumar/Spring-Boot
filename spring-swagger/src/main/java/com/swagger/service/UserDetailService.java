package com.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swagger.dao.UserRepository;
import com.swagger.model.User;
import com.swagger.model.UserDetail;
@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No User");
		}
		return  new UserDetail(user);
		
	}

}
