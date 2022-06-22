package com.demo.boot.serviceimpl;

import java.util.List;
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

import com.demo.boot.config.UserDetailConfig;
import com.demo.boot.entity.User;
import com.demo.boot.repository.UserRepository;
import com.demo.boot.service.UserService;

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
	public Optional<User> findByUsername(String username) {

		return repo.findByUsername(username);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> opt = findByUsername(username);
		if (opt.isEmpty()) {
			throw new UsernameNotFoundException("User not exist");
		}

		// Read user from Database
		User user = opt.get();
      	return new UserDetailConfig(user);
		}
		
	


}
