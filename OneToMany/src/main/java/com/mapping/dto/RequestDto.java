package com.mapping.dto;

import com.mapping.entity.Customer;

public class RequestDto {
	
	
	private Customer customer;
	
	

	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDto(Customer customer) {
		super();
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "RequestDto [customer=" + customer + "]";
	}

}
