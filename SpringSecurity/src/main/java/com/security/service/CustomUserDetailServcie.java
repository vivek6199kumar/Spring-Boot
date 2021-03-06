package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.dao.UserRepository;
import com.security.model.CustomerUserDetail;
import com.security.model.User;
@Service
public class CustomUserDetailServcie implements UserDetailsService {
	
    @Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.repository.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("No User");
		}
		return new CustomerUserDetail(user);
	}

}
