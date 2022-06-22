package com.demo.boot.repository;
import com.demo.boot.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface StudentSubjectDao  extends JpaRepository<StudentSubject,Integer>{
	
	@Modifying
	@Query("delete from StudentSubject  where studentId =:id")
	public void deleteRowBySudentId(int id);
	@Modifying
	@Query("delete from StudentSubject  where subjectId =:id")
	public void deleteRowBySubjectId(int id);


}
