package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.dao.CustomerRepository;
import com.security.dao.UserRepository;
import com.security.model.CustomerDetails;

@Service
public class CustomerDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	public void addCustomer(CustomerDetails cust)
	{
		this.customerRepository.save(cust);
		
	}

}


