package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	// Fake Contact
	List<Contact> list = List.of(
			new Contact(1L, "vivek@gmail.com", "Vivek", 1311L),
			new Contact(4L, "yashwant@gmail.com", "yashwant", 1311L),
			new Contact(2L, "bharat@gmail.com", "Bharat", 1312L), 
			new Contact(3L, "subodh@gmail.com", "Subodh", 1313L)

	);

	@Override
	public List<Contact> getContactOfUser(Long userId) {

		return this.list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
