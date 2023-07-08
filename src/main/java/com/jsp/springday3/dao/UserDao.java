package com.jsp.springday3.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springday3.dto.User;
import com.jsp.springday3.repository.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User getUserById(int id) {
		Optional<User> userOptional = repo.findById(id);
		return userOptional.get();
	}

	public User deleteUserById(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			repo.delete(user);
			return user;
		} else {
			return null;
		}

	}

	public List<User> getAllUser() {
		return repo.findAll();
	}

	public User updateUser(int id, User user) {
		Optional<User> Optional = repo.findById(id);
		if (Optional.isPresent()) {
			user.setId(id);
			repo.save(user);
			return user;
		} else {
			return null;
		}

	}

	public User findUserByName(String name) {
		User user = repo.findUserByName(name);
		return user;
	}

}
