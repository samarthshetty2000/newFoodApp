package com.clarivate.FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.FoodApp.dao.ResponseStructure;
import com.clarivate.FoodApp.dto.FoodOrder;
import com.clarivate.FoodApp.service.FoodOrderService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodOrderController {
	
	@Autowired
	FoodOrderService foodOrderService;

	@PostMapping("/foodOrder")
	public ResponseStructure<FoodOrder> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
//		System.out.println(foodOrder.);
		return foodOrderService.saveFoodOrder(foodOrder);
	}

	@GetMapping("/foodOrder")
	public ResponseStructure<List<FoodOrder>> getAllFoodOrders() {
		return foodOrderService.getAllFoodOrdersData();
	}

	@GetMapping("/foodOrder/{id}")
	public ResponseStructure<FoodOrder> getFoodOrderById(@PathVariable int id) {
		return foodOrderService.getFoodOrderById(id);
	}

	@DeleteMapping("/foodOrder/{id}")
	public ResponseStructure<String> deleteFoodOrder(@PathVariable int id) {
		return foodOrderService.deleteFoodOrder(id);

	}

	@PutMapping("/foodOrder/{id}")
	public ResponseStructure<FoodOrder> updateFoodOrder(@RequestBody FoodOrder foodOrder,@PathVariable int id) {
		return foodOrderService.updateFoodOrder(foodOrder,id);
	}
	
	@GetMapping("/orderdetails/{user_id}")
	public ResponseStructure<List<FoodOrder>> getFoodOrderByStaffId(@PathVariable int user_id) {
		return foodOrderService.getAllFoodOrdersDataByUserId(user_id);
	}
}
