package com.clarivate.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.FoodApp.dto.Item;
import com.clarivate.FoodApp.repository.ItemRepo;


@Repository
public class ItemDao {
	
	@Autowired
	ItemRepo itemRepo;

	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}

	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}

	public Item getItembyId(int id) {
		Optional<Item> optional = itemRepo.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public String deleteItem(int id) {
		Optional<Item> optional = itemRepo.findById(id);
		
		if(optional.isPresent()) {
			itemRepo.delete(optional.get());
			return "Item data "+ id +" has been deleted successfully";
		} else {
			return "Item data with ID:"+ id +" doesn't exist";
		}
	}
	
	public Item updateItem (Item item) {
		return itemRepo.save(item);
	}
}
