package com.criteria.builder.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.Table;
@Entity
@Table(name = "course")
public class Course {
	@Id
	@Column(name = "c_id")
	private int courseID;
	@Column(name = "c_name")
	private String courseName;
	
	@Column(name="cp_fk")
	private int cpfk;
	

	public int getCpfk() {
		return cpfk;
	}

	
	
	
	public Course() {
		super();
	}




	public void setCpfk(int cpfk) {
		this.cpfk = cpfk;
	}


	public Course(int courseID, String courseName) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + "]";
	}

}
