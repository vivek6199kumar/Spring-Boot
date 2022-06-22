package com.demo.boot.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.boot.entity.Subject;
import com.demo.boot.repository.StudentSubjectDao;
import com.demo.boot.repository.SubjectBookDao;
import com.demo.boot.repository.SubjectRepo;
import com.demo.boot.repository.SubjectTeacherDao;
import com.demo.boot.requestdto.SubjectRequestDto;
import com.demo.boot.responseDto.SubjectResponseDto;
import com.demo.boot.service.SubjectService;
import com.demo.boot.setter.SubjectSetter;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	
	@Autowired
	private StudentSubjectDao studentSubjectDao;

	@Autowired
	private SubjectTeacherDao subjectTeacherDao;
	@Autowired
	private SubjectBookDao subjectBookDao;
	@Autowired
	private SubjectRepo repo;

	// 1--Method for saving Subject details
	@Override
	public void saveSubjectDetails(SubjectRequestDto dto) {

		this.repo.save(SubjectSetter.subjectSetter(dto));

	}

	// 2-- Method for getAll List of Subject
	@Override
	public List<SubjectResponseDto> getAllSubject() {
		List<Subject> list = this.repo.findAll();
		List<SubjectResponseDto> l1 = new ArrayList<SubjectResponseDto>();
		list.forEach((e) -> {
			l1.add(SubjectSetter.subjectGetter(e));
		});

		return l1;
	}

	//3--Getting subject by id
	@Override
	public SubjectResponseDto getSubjectsById(int id) {
		Subject t = this.repo.getById(id);

		return SubjectSetter.getIdSetter(t);
	}

	// 4- Method for update Subject by id
	@Override
	public void updateSubject(int id, SubjectRequestDto dto) {
		try {
			Subject tid = this.repo.getById(id);
			if (tid == null) {
				System.out.println("User not found");
			} else {
				this.repo.save(SubjectSetter.subjectUpdate(id, dto));
				System.out.println("User Updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User not found");

		}
	}

	// 5--Delete Subject by id
	@Override
	public String deleteSubject(int id) {
		studentSubjectDao.deleteRowBySubjectId(id);
		subjectTeacherDao.deleteRowBySubjectId(id);
		subjectBookDao.deleteRowBySubjectId(id);
		repo.deleteById(id);
		return "Subject deleted";

	}
	
	public List<SubjectRequestDto> getSubjectByStudentId(int id) {

		List<Subject> list = repo.getSubjectsByStudentId(id);
		List<SubjectRequestDto> l1 = new ArrayList<>();

		list.forEach((e) -> {
			l1.add(SubjectSetter.setDto(e));
		});
		return l1;
	}

	public List<SubjectRequestDto> getSubjectByTeacherId(int id) {

		List<Subject> list = repo.getSubjectsByteacherId(id);

		List<SubjectRequestDto> l1 = new ArrayList<>();

		list.forEach((e) -> {
			l1.add(SubjectSetter.setDto(e));
		});
		return l1;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

	

}