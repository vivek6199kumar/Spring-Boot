package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByName(String name);
	
	@Query("select u from User u")
	public List<User> getList();
	
	@Query("select u from User u where u.name=:n")
	public List<User> getUserByName(@Param("n") String name);

}
