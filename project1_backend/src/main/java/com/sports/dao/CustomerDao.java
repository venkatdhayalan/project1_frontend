package com.sports.dao;

import com.sports.model.Customer;
import com.sports.model.User;

public interface CustomerDao {
	 
	void registerCustomer(Customer customer);
	boolean isEmailValid(String email);
	boolean isUsernameValid(String username);
	User getUser(String username);
	
}
