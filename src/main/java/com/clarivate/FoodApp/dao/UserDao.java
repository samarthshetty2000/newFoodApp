package com.clarivate.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.FoodApp.dto.User;
import com.clarivate.FoodApp.repository.UserRepo;

@Repository
public class UserDao {

	@Autowired
	UserRepo userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getAllUsersData() {
		return userRepo.findAll();
	}

	public User getUserById(int id) {
		Optional<User> optional = userRepo.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public String deleteUser(int id) {
		Optional<User> optional = userRepo.findById(id);

		if (optional.isPresent()) {
			userRepo.delete(optional.get());
			return "Person data has been deleted successfully";
		} else {
			return "Person with this ID doesn't exist";
		}
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	
	
	public User login(User user) {
		return(userRepo.findByEmailAndPwd(user.getEmail(), user.getPwd()));
		
	}

}
