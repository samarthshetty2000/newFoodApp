package com.clarivate.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.FoodApp.dto.FoodOrder;
import com.clarivate.FoodApp.repository.FoodOrderRepo;

@Repository
public class FoodOrderDao {
	
	@Autowired
	FoodOrderRepo foodOrderRepo;

	public FoodOrder saveOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}

	public List<FoodOrder> getAllFoodOrdersData() {
		return foodOrderRepo.findAll();
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional = foodOrderRepo.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public String deleteFoodOrder(int id) {
		Optional<FoodOrder> optional = foodOrderRepo.findById(id);
		
		if(optional.isPresent()) {
			foodOrderRepo.delete(optional.get());
			return "Food order data "+ id +" has been deleted successfully";
		} else {
			return "Food order with ID:"+ id +" doesn't exist";
		}
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}

}
