package com.jsp.springday3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springday3.dao.UserDao;
import com.jsp.springday3.dto.User;
import com.jsp.springday3.exception.IdNotFoundException;
import com.jsp.springday3.exception.NameNotFoundException;
import com.jsp.springday3.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser = dao.saveUser(user);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setMessage("data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new  ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User dbUser = dao.getUserById(id);
		if (dbUser!=null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("data fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		
	}else {
		throw new IdNotFoundException("sorry failed to fetch");
	}
		

	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(int id) {
		User dbUser = dao.deleteUserById(id);
		if (dbUser!=null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("data deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("sorry failed to delete");
//			ResponseStructure<User> structure = new ResponseStructure<User>();
//			structure.setMessage("id not found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(dbUser);
//			return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<User>> getAllUser() {
		List<User> dbUser = dao.getAllUser();
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setMessage("ALL data displayed successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dbUser);
		return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser = dao.updateUser(id, user);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setMessage("data updated successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dbUser);
		return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<User>> findUserByName(String name) {
		User dbUser = dao.findUserByName(name);
		if (dbUser!=null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("data fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		
	}else {
		throw new NameNotFoundException("sorry failed to fetch");
	}
		

}}
