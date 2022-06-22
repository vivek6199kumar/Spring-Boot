package com.demo.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.boot.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

	
	@Query("select  t from Teacher t where id in (select x.teacherId from StudentTeacher x where x.studentId =:id)")
	public List<Teacher> getTeacherByStdId(int id);
}
