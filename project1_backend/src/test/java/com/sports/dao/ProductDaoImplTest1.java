package com.sports.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sports.configuration.DBConfiguration;
import com.sports.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DBConfiguration.class,ProductDaoImpl.class})
@Transactional
public class ProductDaoImplTest1 {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
	@Test
	public void testGetAllProducts() {
	
			ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
			List<Product>products = productDao.getAllProducts();
			assertTrue(products.size()>0);
		
	}

	@Test
	public void testGetProduct() {
		

		ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
		Product product=productDao.getProduct(1);
		assertNotNull(product);
		Product product1=productDao.getProduct(405);
		assertNull(product1);
		
	}

	@Test
	public void testDeleteProduct() {
		
		ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
		productDao.deleteProduct(11);
		Product product=productDao.getProduct(3);
		assertNull(product);
		
		
		
	}

}
