package com.security.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.model.User;
import com.security.repo.UserRepository;
import com.security.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository repo; // HAS-A
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	// 1st Method for saving User
	@Override
	public Integer saveUser(User user) {

		// Encode Password
		user.setPassword(pwdEncoder.encode(user.getPassword()));

		return repo.save(user).getId();
	}

	// Get user by username
	@Override
	public Optional<User> findByUsername(String username) {

		return repo.findByUsername(username);
	}

	// -----------------------------------------------------------//
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt = findByUsername(username);
		if (opt.isEmpty()) {
			throw new UsernameNotFoundException("User not exist");
		}

		// Read user from Database
		User user = opt.get();

		return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
				user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
	}

}
