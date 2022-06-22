package com.demo.boot.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.boot.entity.Student;
import com.demo.boot.entity.Teacher;
import com.demo.boot.repository.StudentRepo;
import com.demo.boot.repository.StudentSubjectDao;
import com.demo.boot.repository.StudentTeacherDao;
import com.demo.boot.repository.TeacherRepo;
import com.demo.boot.requestdto.StudentRequestDto;
import com.demo.boot.requestdto.TeacherRequestDto;
import com.demo.boot.responseDto.StudentResponseDto;
import com.demo.boot.service.StudentService;
import com.demo.boot.setter.StudentSetter;
import com.demo.boot.setter.TeacherSetter;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentTeacherDao studentTeacherDao;
	@Autowired
	private StudentSubjectDao studentSubjectDao;

	@Autowired
	private StudentRepo repo;

	// 1--Method for saving teacher details
	@Override
	public void saveStudentDetails(StudentRequestDto dto) {

		this.repo.save(StudentSetter.studentSetter(dto));

	}

	// 2-- Method for getAll List of teacher
	@Override
	public List<StudentResponseDto> getAllStudent() {
		List<Student> list = this.repo.findAll();
		List<StudentResponseDto> l1 = new ArrayList<StudentResponseDto>();
		list.forEach((e) -> {
			l1.add(StudentSetter.studentgetter(e));
		});

		return l1;
	}

	@Override
	public StudentResponseDto getStudentsById(int id) {
		Student t = this.repo.getById(id);

		return StudentSetter.getIdSetter(t);
	}

	// 4- Method for update teacher by id
	@Override
	public void updateStudent(int id, StudentRequestDto dto) {
		try {
			Student tid = this.repo.getById(id);
			if (tid == null) {
				System.out.println("User not found");
			} else {
				this.repo.save(StudentSetter.studentUpdate(id, dto));
				System.out.println("User Updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User not found");

		}
	}

	// 5--Delete teacher by id

	@Override
	public String deleteStudent(int id) {
	
		
		studentTeacherDao.deleteRowBySudentId(id);
		studentSubjectDao.deleteRowBySudentId(id);
		repo.deleteById(id);
		return "Student deleted";
		}

	
	public List<StudentRequestDto> getStudentsByTeacherId(int id) {

		List<Student> list = repo.getStudentsByTeacherId(id);

		List<StudentRequestDto> l1 = new ArrayList<>();
		list.forEach((e) -> {
			l1.add(StudentSetter.setStudentDto(e));
		});

		return l1;
	
	}
	
	}

	
