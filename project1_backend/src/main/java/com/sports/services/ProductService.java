package com.sports.services;

import java.util.List;

import com.sports.model.Category;
import com.sports.model.Product;


public interface ProductService {

	List<Product> getAllProducts();
	Product getProduct(int id);
	void deleteProduct(int id);
	List<Category> getAllCategories();
	void saveOrUpdateProduct(Product product);
}
