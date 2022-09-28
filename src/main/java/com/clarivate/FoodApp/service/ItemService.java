package com.clarivate.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.FoodApp.dao.FoodOrderDao;
import com.clarivate.FoodApp.dao.ItemDao;
import com.clarivate.FoodApp.dao.ResponseStructure;
import com.clarivate.FoodApp.dto.FoodOrder;
import com.clarivate.FoodApp.dto.Item;

@Service
public class ItemService {

	@Autowired
	ItemDao itemDao;
	
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public ResponseStructure<Item> saveItem(Item item){
		ResponseStructure<Item> response = new ResponseStructure<Item>();
		
		FoodOrder foodOrder=foodOrderDao.getFoodOrderById(item.getFoodOrder().getId());
		item.setFoodOrder(foodOrder);
		
		Item item2 = itemDao.saveItem(item);
		if(item2 != null) {
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMsg("Item added successfully");
			response.setData(item2);
		}
		return response;
	}
	
	public ResponseStructure<List<Item>> getAllItems(){
		
		ResponseStructure<List<Item>> response = new ResponseStructure<List<Item>>();
		List<Item> list=itemDao.getAllItems();
		
		if(list.isEmpty()) {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Item not found");
			response.setData(null);
		} else {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Item Details");
			response.setData(list);
			
		}
		return response;
	}
	
	public ResponseStructure<Item> getItemById(int id){
		ResponseStructure<Item> response = new ResponseStructure<Item>();
		Item item = itemDao.getItembyId(id);
		if(item!=null) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Item Details");
			response.setData(item);
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Item not found");
			response.setData(null);
		}
		return response;
	}
	
	public ResponseStructure<String> deleteItem(int id){
		ResponseStructure<String> response = new ResponseStructure<String>();
		
		Item item = itemDao.getItembyId(id);
		if(item!=null) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Item is deleted");
			response.setData(itemDao.deleteItem(id));
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Item not found");
			response.setData(null);
		}
		return response;
	}
	
	public ResponseStructure<Item> updateItem(Item item){
		
		ResponseStructure<Item> response = new ResponseStructure<Item>();
		
		Item item2 = itemDao.getItembyId(item.getId());
		if(item2!=null) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Item data is updated");
			response.setData(itemDao.updateItem(item));
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Item not found");
			response.setData(null);
		}
		return response;
	
	}	
}
