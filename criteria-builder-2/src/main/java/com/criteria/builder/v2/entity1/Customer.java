package com.criteria.builder.v2.entity1;

/*-------------->OneToMany  Bidirectional-----------------------> */

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Customers")
public class Customer {
	
	@Id
	@Column(name="cus_id")
	private int customerId;
	@Column(name="cus_address")
	private String customerAddress;
	@Column(name="cus_name")
	private  String customerName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ven_id")
	private Vendor vendor;

	// Default Constructor
	public Customer() {
		super();
		
	}

	// Parametric Constructor
	public Customer(int customerId, String customerAddress, String customerName, Vendor vendor) {
		super();
		this.customerId = customerId;
		this.customerAddress = customerAddress;
		this.customerName = customerName;
		this.vendor = vendor;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerAddress=" + customerAddress + ", customerName="
				+ customerName + "]";
	}

}
