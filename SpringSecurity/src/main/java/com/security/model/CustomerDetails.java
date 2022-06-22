package com.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerDetails {
    @Id
	private int id;
	private String customername;
	private String address;
	private String number;
	
	public CustomerDetails() {
		super();
	}

	public CustomerDetails(int id, String customername, String address, String number) {
		super();
		this.id = id;
		this.customername = customername;
		this.address = address;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", customername=" + customername + ", address=" + address + ", number="
				+ number + "]";
	}
	
	
	
}
