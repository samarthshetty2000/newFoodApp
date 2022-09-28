package com.clarivate.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.FoodApp.dto.FoodProduct;
import com.clarivate.FoodApp.repository.FoodProductRepo;

@Repository
public class FoodProductDao {
	
	@Autowired
	FoodProductRepo foodProductRepo;
	
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		return foodProductRepo.save(foodProduct);
	}
	
	public List<FoodProduct> getAllFoodProductsData() {
		return foodProductRepo.findAll();
	}

	public FoodProduct getFoodProductById(int id) {
		Optional<FoodProduct> optional = foodProductRepo.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public String deleteFoodProduct(int id) {
		Optional<FoodProduct> optional = foodProductRepo.findById(id);
		
		if(optional.isPresent()) {
			foodProductRepo.delete(optional.get());
			return "Food product data "+ id +" has been deleted successfully";
		} else {
			return "Food product with ID:"+ id +" doesn't exist";
		}
	}
	
	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		return foodProductRepo.save(foodProduct);
	}
}
