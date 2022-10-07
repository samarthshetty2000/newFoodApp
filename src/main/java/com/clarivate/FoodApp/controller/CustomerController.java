package com.clarivate.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.FoodApp.dao.ResponseStructure;
import com.clarivate.FoodApp.service.BusinessServices;
import com.clarivate.FoodApp.service.CustomerService;
import com.clarivate.FoodApp.util.Customer;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	BusinessServices businessServices;
	@Autowired
	CustomerService customerService;
	
	
  @PostMapping("/bill/{id}")
  public ResponseStructure<String> customerDetails(@RequestBody Customer customer,@PathVariable int id) {
	  
	  String status= customerService.adddetails(customer, id);
	  ResponseStructure<String>    responseStructure = new ResponseStructure<String>();
	  responseStructure.setData(status);
	  responseStructure.setMsg("Success");
	  responseStructure.setStatusCode(HttpStatus.OK.value());
//	  businessServices.sendEmail();
	  return  responseStructure;
	  
  }
}
