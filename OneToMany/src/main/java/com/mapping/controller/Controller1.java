package com.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.dto.RequestDto;
import com.mapping.dto.ResponseDto;
import com.mapping.entity.Customer;
import com.mapping.repository.CustomerRepo;
import com.mapping.repository.ProductRepo;

@RestController
public class Controller1 {
 
	@Autowired
	private CustomerRepo customerRepo;
	
	@SuppressWarnings("unused")
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping("/save")
	public Customer placeOrder(@RequestBody RequestDto dto)
	{
		return customerRepo.save(dto.getCustomer());
	}
	
	@GetMapping("/getAll")
	public List<Customer> getAll()
	{
		return this.customerRepo.findAll();
	}
	
	
	@GetMapping("/getInfo")
	public List<ResponseDto> getJoinInformation()
	{
		return this.customerRepo.getJoinInformation();
	}	
	
}
