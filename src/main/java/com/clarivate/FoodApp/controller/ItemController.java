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
import com.clarivate.FoodApp.dto.Item;
import com.clarivate.FoodApp.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping("/items")
	public ResponseStructure<Item> saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}

	@GetMapping("/getItems")
	public ResponseStructure<List<Item>> getAllItems() {
		return itemService.getAllItems();
	}

	@GetMapping("/getItems/{id}")
	public ResponseStructure<Item> getItemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}

	@DeleteMapping("/items/{id}")
	public ResponseStructure<String> deleteItem(@PathVariable int id) {
		return itemService.deleteItem(id);
	}

	@PutMapping("/items")
	public ResponseStructure<Item> updateItem(@RequestBody Item item) {
		return itemService.updateItem(item);
	}
}
