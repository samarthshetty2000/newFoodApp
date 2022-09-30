package com.clarivate.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.FoodApp.dao.FoodProductDao;
import com.clarivate.FoodApp.dao.MenuDao;
import com.clarivate.FoodApp.dao.ResponseStructure;
import com.clarivate.FoodApp.dto.FoodProduct;
import com.clarivate.FoodApp.dto.Menu;

@Service
public class FoodProductService {

	@Autowired
	FoodProductDao foodProductDao;
	
	@Autowired
	MenuDao menuDao;

	public ResponseStructure<FoodProduct> saveFoodProduct(FoodProduct foodProduct) {
		
		Menu menu=menuDao.getMenuById(foodProduct.getMenu().getId());
		
		foodProduct.setMenu(menu);
		
		ResponseStructure<FoodProduct> responseStructure = new ResponseStructure<FoodProduct>();

		FoodProduct foodProduct1 = foodProductDao.saveFoodProduct(foodProduct);

		if (foodProduct1 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(foodProductDao.saveFoodProduct(foodProduct1));
		}
		return responseStructure;
	}

	public ResponseStructure<List<FoodProduct>> getAllFoodProductsData() {

		ResponseStructure<List<FoodProduct>> responseStructure = new ResponseStructure<List<FoodProduct>>();

		List<FoodProduct> foodProductList = foodProductDao.getAllFoodProductsData();

		if (foodProductList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details");
			responseStructure.setData(foodProductList);
		}
		return responseStructure;
	}

	public ResponseStructure<FoodProduct> getFoodProductById(int id) {

		ResponseStructure<FoodProduct> responseStructure = new ResponseStructure<FoodProduct>();

		FoodProduct foodProduct = foodProductDao.getFoodProductById(id);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product Details Obtained");
			responseStructure.setData(foodProduct);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Product Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteFoodProduct(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		FoodProduct foodProduct = foodProductDao.getFoodProductById(id);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food product Details Deleted Successfully");
			responseStructure.setData(foodProductDao.deleteFoodProduct(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food product Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	public ResponseStructure<FoodProduct> updateFoodProduct(FoodProduct foodProduct,int id) {
		
		ResponseStructure<FoodProduct> responseStructure = new ResponseStructure<FoodProduct>();
		
		FoodProduct foodProduct1 = foodProductDao.getFoodProductById(id);
		
		if (foodProduct1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food product data missing");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food product is present");
			responseStructure.setData(foodProductDao.updateFoodProduct(foodProduct));

		}
		return responseStructure;

	}
}
