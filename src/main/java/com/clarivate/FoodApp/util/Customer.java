package com.clarivate.FoodApp.util;

public class Customer {
	private String email;
	private long phone;
	public Customer(String email, long phone) {

		this.email = email;
		this.phone = phone;
	}
	public Customer() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	

}
