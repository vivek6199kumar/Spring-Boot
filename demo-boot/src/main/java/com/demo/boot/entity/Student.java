package com.demo.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private int sid;
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	
	
	public Student() {
		super();

	}



	public Student(int sid, String name, String gender) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
	}



	public int getSid() {
		return sid;
	}



	public void setSid(int sid) {
		this.sid = sid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", gender=" + gender + "]";
	}

	

	
}