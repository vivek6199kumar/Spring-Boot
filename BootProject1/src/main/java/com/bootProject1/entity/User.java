package com.bootProject1.entity;



public class User {


	private int id;

	private String name;
	private String city;

	private String status;

	public User() {
		super();
	}

	public User(int id,String name, String city, String status) {

		this.name = name;
		this.city = city;
		this.status = status;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", status=" + status + "]";
	}

}


