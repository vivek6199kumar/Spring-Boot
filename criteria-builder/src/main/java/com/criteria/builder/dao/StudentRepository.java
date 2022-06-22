package com.criteria.builder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criteria.builder.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
