package com.demo.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.boot.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	@Query("select s from Student s where id in (select x.studentId from StudentTeacher x where teacherId=:id)")
	public List<Student> getStudentsByTeacherId(int id);
	
}
