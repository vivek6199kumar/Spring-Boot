package com.demo.boot.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.boot.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	/*
	 * @Query("select u from User u where u.username =:username") public List<User>
	 * findByUsername(String username);
	 */
	Optional<User> findByUsername(String username);
}
