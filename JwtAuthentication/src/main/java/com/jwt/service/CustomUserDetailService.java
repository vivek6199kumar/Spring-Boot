package com.jwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
               System.out.println("3 : " + userName);
		if (userName.equals("vivek")) 
		{
			return new User("vivek", "host", new ArrayList<>());
		}
		else 
		{
			throw new UsernameNotFoundException(userName + "User Not Found");
		}

	}

}
