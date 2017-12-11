package com.sports.services;

import com.sports.model.Customer;
import com.sports.model.User;

public interface CustomerService {
	void registerCustomer(Customer customer);
	boolean isEmailValid(String email);
	boolean isUsernameValid(String username);
	User getUser(String username);

}
