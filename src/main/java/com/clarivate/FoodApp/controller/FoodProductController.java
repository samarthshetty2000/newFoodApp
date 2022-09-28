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
import com.clarivate.FoodApp.dto.FoodProduct;
import com.clarivate.FoodApp.service.FoodProductService;

@RestController
public class FoodProductController {

	@Autowired
	FoodProductService foodProductService;

	@PostMapping("/foodProduct")
	public ResponseStructure<FoodProduct> saveFoodProduct(@RequestBody FoodProduct foodProduct) {
		return foodProductService.saveFoodProduct(foodProduct);
	}

	@GetMapping("/foodProduct")
	public ResponseStructure<List<FoodProduct>> getAllFoodProductsData() {
		return foodProductService.getAllFoodProductsData();
	}

	@GetMapping("/foodProduct/{id}")
	public ResponseStructure<FoodProduct> getFoodProductById(@PathVariable int id) {
		return foodProductService.getFoodProductById(id);
	}

	@DeleteMapping("/foodProduct/{id}")
	public ResponseStructure<String> deleteFoodProduct(@PathVariable int id) {
		return foodProductService.deleteFoodProduct(id);

	}

	@PutMapping("/foodProduct")
	public ResponseStructure<FoodProduct> updateFoodProduct(@RequestBody FoodProduct foodProduct) {
		return foodProductService.updateFoodProduct(foodProduct);
	}
}
