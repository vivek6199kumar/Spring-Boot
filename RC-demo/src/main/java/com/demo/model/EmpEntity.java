package com.demo.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class EmpEntity {
	
	private int id;
	private  String name;
	private Date date;
	private HttpStatus status;
	public EmpEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpEntity(int id, String name, Date date, HttpStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.status = status;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	

}
