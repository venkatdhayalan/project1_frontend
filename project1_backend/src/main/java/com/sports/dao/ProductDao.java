package com.sports.dao;

import java.util.List;

import com.sports.model.Category;
import com.sports.model.Product;


public interface ProductDao {
	

	List<Product> getAllProducts(); //select * from product
	Product getProduct(int id);
	void deleteProduct(int id); //delete from product where id=?
	List<Category> getCategories();
	void saveOrUpdateProduct(Product product);

	
	
}





