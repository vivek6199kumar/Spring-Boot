package com.criteria.builder.v2.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable{

	private static final long serialVersionUID = -4586667500825431401L;
	@Id
	@Column(name="pid")
	private int pid;
	@Column(name="product_name")
	private String productName;
	@Column(name="qty")
	private int qty;
	@Column(name="price")
	private int price;
	@Column(name = "c_id")
	private int cID;

	
	
  //Default Constructor
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	//Parametric Constructor
	public Product(int pid, String productName, int qty, int price, int cID) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.qty = qty;
		this.price = price;
		this.cID = cID;
	}


	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/*
	 * public Product( int price , int qty ,String productName) { this.productName =
	 * productName; this.qty = qty; this.price = price; }
	 */


	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productName=" + productName + ", qty=" + qty + ", price=" + price + ", cID="
				+ cID + "]";
	}




}
