package com.clarivate.FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.FoodApp.dao.ResponseStructure;
import com.clarivate.FoodApp.dto.User;
import com.clarivate.FoodApp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users")
	public ResponseStructure<List<User>> getAllUsers() {
		return userService.getAllUserData();
	}

	@GetMapping("/users/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/users/{id}")
	public ResponseStructure<String> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);

	}

	@PutMapping("/users")
	public ResponseStructure<User> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<User>> login(@RequestBody User user){
		System.out.println(user.getEmail());
		
		return userService.login(user);
		
	}

}
