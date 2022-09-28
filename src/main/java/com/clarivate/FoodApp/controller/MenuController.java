package com.clarivate.FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.FoodApp.dao.ResponseStructure;
import com.clarivate.FoodApp.dto.Menu;
import com.clarivate.FoodApp.service.MenuService;

@RestController
public class MenuController {
	
	@Autowired
	MenuService menuService;

	@PostMapping("/menu")
	public ResponseStructure<Menu> saveUser(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}

	@GetMapping("/menu")
	public ResponseStructure<List<Menu>> getAllMenu() {
		return menuService.getAllMenuData();
	}

	@GetMapping("/menu/{id}")
	public ResponseStructure<Menu> getMenuById(@PathVariable int id) {
		return menuService.getMenuById(id);
	}

	@DeleteMapping("/menu/{id}")
	public ResponseStructure<String> deleteMenu(@PathVariable int id) {
		return menuService.deleteMenu(id);

	}

	@PutMapping("/menu")
	public ResponseStructure<Menu> updateMenu(@RequestBody Menu menu) {
		return menuService.updateMenu(menu);
	}
}
