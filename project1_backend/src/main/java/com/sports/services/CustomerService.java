package com.sports.services;

import com.sports.model.Customer;

public interface CustomerService {
	void registerCustomer(Customer customer);
	boolean isEmailValid(String email);
	boolean isUsernameValid(String username);

}
