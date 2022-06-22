package com.criteria.builder.dto;

import java.util.List;

public class StudentDto {
	
	private int age;
	private String name;
	
	private List<CourseDto> listCourseDtos;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CourseDto> getListCourseDtos() {
		return listCourseDtos;
	}

	public void setListCourseDtos(List<CourseDto> listCourseDtos) {
		this.listCourseDtos = listCourseDtos;
	}

	@Override
	public String toString() {
		return "StudentDto [age=" + age + ", name=" + name + ", listCourseDtos=" + listCourseDtos + "]";
	}



	
	


	
}
