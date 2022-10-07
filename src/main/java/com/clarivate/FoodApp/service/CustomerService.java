package com.clarivate.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarivate.FoodApp.dao.FoodOrderDao;
import com.clarivate.FoodApp.dto.FoodOrder;
import com.clarivate.FoodApp.util.Customer;

@Service
public class CustomerService {
	
	
	@Autowired
	BusinessServices businessService;
	
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public String adddetails(Customer customer,int id)
	{
		FoodOrder foodOrder=foodOrderDao.getFoodOrderById(id);
		foodOrder.setId(id);
		foodOrder.setCustomerName(customer.getEmail());
		foodOrder.setContactNumber(customer.getPhone());
		foodOrder.setStatus("Completed");
		foodOrderDao.saveOrder(foodOrder); 
		float price=foodOrder.getTotalPrice();
		return businessService.sendEmail(price,customer.getEmail());
		
	}
	
}
