package com.clarivate.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clarivate.FoodApp.dao.ResponseStructure;
import com.clarivate.FoodApp.dao.UserDao;
import com.clarivate.FoodApp.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		User user1 = userDao.saveUser(user);

		if (user1 != null) {
			
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(user1);
		}
		
		return responseStructure;
	}

	public ResponseStructure<List<User>> getAllUserData() {

		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();

		List<User> userList = userDao.getAllUsersData();

		if (userList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details");
			responseStructure.setData(userList);
		}
		return responseStructure;
	}

	public ResponseStructure<User> getUserById(int id) {

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		User user = userDao.getUserById(id);

		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details Obtained");
			responseStructure.setData(user);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("User Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteUser(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		User user = userDao.getUserById(id);

		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details Deleted Successfully");
			responseStructure.setData(userDao.deleteUser(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("User Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	public ResponseStructure<User> updateUser(User user,int id) {
		
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		
		User u1 = userDao.getUserById(id);
		user.setPwd(u1.getPwd());
		
		if (u1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("User data missing");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User is present");
			responseStructure.setData(userDao.updateUser(user));

		}
		return responseStructure;

	}

	public ResponseEntity<ResponseStructure<User>> login(User user) {
		User user1 =userDao.login(user);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		
		if(user1!=null)
		{
			responseStructure.setMsg("login success full");
			responseStructure.setData(user1);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
			
		}
		else
		{
			responseStructure.setMsg("login failed");
			//responseStructure.setData();
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
		
		
	}

	public ResponseStructure<List<User>> getUserByrole(String role) {
		// TODO Auto-generated method stub
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
	List<User> userList=userDao.getAllUsersByRole(role);

		if (userList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details");
			responseStructure.setData(userList);
		}
		return responseStructure;
	}

}
