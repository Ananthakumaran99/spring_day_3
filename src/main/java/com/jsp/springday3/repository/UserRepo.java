package com.jsp.springday3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springday3.dto.User;

public interface UserRepo  extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.name=?1")
	public User findUserByName(String name);
	

}
