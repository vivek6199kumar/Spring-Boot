package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@GetMapping("/host/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		User user = this.service.getUser(userId);
		// http://localhost:9002/swagger-ui.html

		List contacts = this.restTemplate.getForObject("http://CONTACT-SERVICE/contact/user/" + userId, List.class);
		user.setContacts(contacts);
		return user;

	}

}
