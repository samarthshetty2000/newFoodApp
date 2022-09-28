package com.clarivate.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.FoodApp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByEmailAndPwd(String email,String pwd);

}
