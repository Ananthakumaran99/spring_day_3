package com.jsp.springday3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springday3.dao.UserDao;
import com.jsp.springday3.dto.User;
import com.jsp.springday3.service.UserService;
import com.jsp.springday3.util.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody  @Valid  User user) {
		return service.saveUser(user);
	}

	@GetMapping("/get")
	public ResponseEntity<ResponseStructure<User>> getUser(@RequestParam int id) {
		return service.getUserById(id);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id) {
		return service.deleteUserById(id);
	}

	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<User>> getAllUser() {
		return service.getAllUser();
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int id, @RequestBody User user) {
		return service.updateUser(id, user);
	}


	
	
	@GetMapping("/name")
	public ResponseEntity<ResponseStructure<User>> findUserByName(@RequestParam String name) {
		return service.findUserByName(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//	@Autowired
//	private UserDao dao;
//	@PostMapping("/save")
//	public User saveUser(@RequestBody User user) {
//		 return dao.saveUser(user);
//}
//	
//	@GetMapping("/get")
//	public User getUser(@RequestParam int id) {
//		 return dao.getUserById(id);
//}
//	
//	@DeleteMapping("/delete")
//	public User deleteUser(@RequestParam int id) {
//		 return dao.deleteUserById(id);
//}
//	@GetMapping("/findall")
//	public List<User> getAllUser( ) {
//		 return dao.getAllUser();
//		 }
//
//	@PutMapping("/update")
//	public User updateUser(@RequestParam int id,@RequestBody User user) {
//		return dao.updateUser(id,user);
//	}

}
