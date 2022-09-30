package com.clarivate.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.FoodApp.service.BusinessServices;
import com.clarivate.FoodApp.util.Customer;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	BusinessServices businessServices;
	
	
  @PostMapping("/bill")
  public Customer customerDetails(@RequestBody Customer customer) {
	  
	  businessServices.sendEmail();
	  return customer;
  }
}
