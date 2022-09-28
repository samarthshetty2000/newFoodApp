package com.clarivate.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.FoodApp.dto.Menu;
import com.clarivate.FoodApp.repository.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	MenuRepo menuRepo;

	public Menu saveMenu(Menu menu) {
		return menuRepo.save(menu);
	}

	public List<Menu> getAllMenuData() {
		return menuRepo.findAll();
	}

	public Menu getMenuById(int id) {
		
		Optional<Menu> optional = menuRepo.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public String deleteMenu(int id) {
		
		Optional<Menu> optional = menuRepo.findById(id);

		if (optional.isPresent()) {
			menuRepo.delete(optional.get());
			return "Menu data has been deleted successfully";
		} else {
			return "Menu with this ID doesn't exist";
		}
	}

	public Menu updateMenu(Menu menu) {
		return menuRepo.save(menu);
	}
}
