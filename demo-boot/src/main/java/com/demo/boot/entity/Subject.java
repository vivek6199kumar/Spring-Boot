package com.demo.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subid")
	private int subjectID;
	
	@Column(name = "name")
	private String name;
	
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int subjectID, String name) {
		super();
		this.subjectID = subjectID;
		this.name = name;
			}
	

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Subject [subjectID=" + subjectID + ", name=" + name + "]";
	}



	
	
	
}
