package com.criteria.builder.setter;

import java.util.ArrayList;
import java.util.List;

import com.criteria.builder.dto.CourseDto;
import com.criteria.builder.dto.StudentDto;
import com.criteria.builder.entity.Course;
import com.criteria.builder.entity.StudentEntity;

public class StudentCourseSetter {

	public static StudentEntity setStudnent(StudentDto dto) {

		StudentEntity st = new StudentEntity();

		st.setS_name(dto.getName());

		st.setS_age(dto.getAge());

		st.setCourse(setCourse(dto.getListCourseDtos()));

		return st;

	}

	public static List<Course> setCourse(List<CourseDto> courseDtos) {

		List<Course> courses = new ArrayList<>();

		courseDtos.forEach((e) -> {
			Course c = new Course();
			c.setCourseName(e.getName());
			c.setCourseID(e.getCourseId());
			courses.add(c);

		});

		return courses;

	}

}