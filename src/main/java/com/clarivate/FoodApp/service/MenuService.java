package com.clarivate.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.FoodApp.dao.MenuDao;
import com.clarivate.FoodApp.dao.ResponseStructure;
import com.clarivate.FoodApp.dao.UserDao;
import com.clarivate.FoodApp.dto.Menu;
import com.clarivate.FoodApp.dto.User;

@Service
public class MenuService {
	
	@Autowired
	MenuDao menuDao;
	@Autowired
	UserDao userDao;
	
	

	public ResponseStructure<Menu> saveMenu (Menu menu) {
		
		User user=userDao.getUserById(menu.getUser().getId());
		
		menu.setUser(user);
     	user.setMenu(menu);
//		userDao.saveUser(user);
		
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();

	Menu menu1 = menuDao.saveMenu(menu);

		if (menu1 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(menuDao.saveMenu(menu1));
		}
		return responseStructure;
	}

	public ResponseStructure<List<Menu>> getAllMenuData() {

		ResponseStructure<List<Menu>> responseStructure = new ResponseStructure<List<Menu>>();

		List<Menu> menuList = menuDao.getAllMenuData();

		if (menuList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Menu Details");
			responseStructure.setData(menuList);
		}
		return responseStructure;
	}

	public ResponseStructure<Menu> getMenuById(int id) {

		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();

		Menu menu = menuDao.getMenuById(id);

		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Menu Details Obtained");
			responseStructure.setData(menu);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Menu Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteMenu(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		Menu menu = menuDao.getMenuById(id);

		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Menu Details Deleted Successfully");
			responseStructure.setData(menuDao.deleteMenu(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Menu Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	public ResponseStructure<Menu> updateMenu(Menu menu) {
		
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		
		Menu menu1 = menuDao.getMenuById(menu.getId());
		
		if (menu1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Menu data not found");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Menu is present");
			responseStructure.setData(menuDao.updateMenu(menu));

		}
		return responseStructure;

	}
}
