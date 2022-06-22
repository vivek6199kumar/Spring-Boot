package com.bootProject1.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bootProject1.entity.User;

@Service
public class ServiceImpl {
	User u1 = new User(1, "Vivek Kumar", "Bihar", "Software Developer");
	User u2 = new User(2, "Bharat Rawat", "Gurgaon", "Software Developer");
	List<User> list = new ArrayList<User>();

	
	
	
	public ServiceImpl() {
		list.add(u1);
		list.add(u2);
	}

	public User getUser(int id) {
		list.add(u1);
		list.add(u2);
		User user = null;
		for (User u : list) {
			if (u.getId() == id) {
				user = u;
			}
		}

		return user;

	}

	public String addUser(User user) {
		list.add(user);
		return null;
	}

	public List<User> getAllList() {
		return list;
	}

}
