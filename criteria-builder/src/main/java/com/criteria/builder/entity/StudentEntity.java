package com.criteria.builder.entity;

import java.util.List;

import javax.persistence.*;

import com.criteria.builder.dto.CourseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;
	private String s_name;
	private int s_age;

	@OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_fk")
	private List<Course> course;

	public StudentEntity() {
		super();
	}

	public StudentEntity(int s_id, String s_name, int s_age, List<Course> course) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_age = s_age;
		this.course = course;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_age() {
		return s_age;
	}

	public void setS_age(int s_age) {
		this.s_age = s_age;
	}


	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentEntity [s_id=" + s_id + ", s_name=" + s_name + ", s_age=" + s_age + ", course=" + course + "]";
	}

	



}