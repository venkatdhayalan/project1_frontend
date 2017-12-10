package com.sports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.dao.CustomerDao;
import com.sports.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	public void registerCustomer(Customer customer) {
		customerDao.registerCustomer(customer);
		
	}
	public boolean isEmailValid(String email) {
		// TODO Auto-generated method stub
		return customerDao.isEmailValid(email);
	}
	public boolean isUsernameValid(String username) {
		// TODO Auto-generated method stub
		return customerDao.isUsernameValid(username);
	}

}
