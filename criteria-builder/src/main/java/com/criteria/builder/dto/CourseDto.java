package com.criteria.builder.dto;

public class CourseDto {

	private  int courseId;
	private String name;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CourseDto [courseId=" + courseId + ", name=" + name + "]";
	}
	
	
	
	
}
