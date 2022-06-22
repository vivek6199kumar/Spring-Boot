package com.demo.boot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@Column(name = "tid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;

	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private String gender;

	public Teacher() {
		super();

	}

	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Teacher(int tid, String name) {
		super();
		this.tid = tid;
		this.name = name;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", gender=" + gender + "]";
	}




}
