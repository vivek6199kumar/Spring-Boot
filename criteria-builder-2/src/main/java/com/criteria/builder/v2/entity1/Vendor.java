package com.criteria.builder.v2.entity1;

/*-------------->OneToMany  Bidirectional-----------------------> */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
public class Vendor {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "vendor_name")
	private String vendorName;

	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
	private List<Customer> customers;

	// Default Constructor
	public Vendor() {
		super();
	}

	// Parametric Constructor
	public Vendor(int id, String vendorName, List<Customer> customers) {
		super();
		this.id = id;
		this.vendorName = vendorName;
		this.customers = customers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", vendorName=" + vendorName + "]";
	}

}
