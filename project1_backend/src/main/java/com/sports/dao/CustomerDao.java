package com.sports.dao;

import com.sports.model.Customer;

public interface CustomerDao {
	 
	void registerCustomer(Customer customer);
	boolean isEmailValid(String email);
	boolean isUsernameValid(String username);
	
}
