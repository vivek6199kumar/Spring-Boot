package com.demo.boot.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.boot.entity.Teacher;
import com.demo.boot.repository.StudentRepo;
import com.demo.boot.repository.StudentTeacherDao;
import com.demo.boot.repository.SubjectTeacherDao;
import com.demo.boot.repository.TeacherRepo;
import com.demo.boot.requestdto.TeacherRequestDto;
import com.demo.boot.responseDto.TeacherResponseDto;
import com.demo.boot.service.TeacherService;
import com.demo.boot.setter.TeacherSetter;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private StudentTeacherDao studentTeacherDao;

	@Autowired
	private SubjectTeacherDao subjectTeacherDao;

	@Autowired
	private TeacherRepo repoT;

	// 1--Method for saving teacher details
	@Override
	public void saveTeacherDetails(TeacherRequestDto dto) {

		this.repoT.save(TeacherSetter.teacherSetter(dto));

	}

	// 2-- Method for getAll List of teacher
	@Override
	public List<TeacherResponseDto> getAllTeacher() {
		List<Teacher> list = this.repoT.findAll();
		List<TeacherResponseDto> l1 = new ArrayList<TeacherResponseDto>();
		list.forEach((e) -> {
			l1.add(TeacherSetter.teachergetter(e));
		});

		return l1;
	}

	@Override
	public TeacherResponseDto getTeachersById(int id) {
		Teacher t = this.repoT.getById(id);

		return TeacherSetter.getIdSetter(t);
	}

	// 4- Method for update teacher by id
	@Override
	public void updateTeacher(int id, TeacherRequestDto dto) {
		try {
			Teacher tid = this.repoT.getById(id);
			if (tid == null) {
				System.out.println("User not found");
			} else {
				this.repoT.save(TeacherSetter.teacherUpdate(id, dto));
				System.out.println("User Updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User not found");

		}
	}

	// 5--Delete teacher by id
	@Override
	public String deleteTeacher(int id) {

		studentTeacherDao.deleteRowByTeacherId(id);
		subjectTeacherDao.deleteRowByTeacherId(id);
		repoT.deleteById(id);

		return "teacher deleted";

	}

	public List<TeacherResponseDto> getTeacherByStdId(int id) {
		List<Teacher> list = repoT.getTeacherByStdId(id);
		List<TeacherResponseDto> l1 = new ArrayList<>();
		list.forEach((e) -> {
			l1.add(TeacherSetter.setDto(e));

		});

		return l1;
	}

}
