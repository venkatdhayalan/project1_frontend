package com.sports.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sports.model.Category;
import com.sports.model.Product;
import com.sports.services.ProductService;


@Controller
public class ProductController {


	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/all/getallproducts")
	public ModelAndView getAllProducts() {
		List<Product> products=productService.getAllProducts();
		//productlist - logical view name [productlist.jsp]
		//products - model attribute [use this attribute in jsp]
		//products - List<Product> data 
		return new ModelAndView("productlist","productsAttr",products);
		//JSTL and EL 
		
	}
	@RequestMapping(value="all/viewproduct/{id}")
	public ModelAndView getProduct(@PathVariable int id) {
		Product product=productService.getProduct(id);
		return new ModelAndView("viewproduct","product",product);
	}
	
	@RequestMapping(value="/admin/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id){
		productService.deleteProduct(id);
		return "redirect:/all/getallproducts";
	
	}
	
	@RequestMapping(value="/admin/getproductform")
	public String getProductForm(@RequestParam(required=false)int id,Model model){
		if(id==0)//add product
		model.addAttribute("product",new Product());//1
		else{
			Product product=productService.getProduct(id);//select * from product where id=?
			model.addAttribute("product",product);
		}
		//SELECT * from Category
		List<Category> categoriesList=productService.getAllCategories();
		model.addAttribute("categories",categoriesList);
		return "productform";
		
	}
	@RequestMapping(value="/admin/saveorupdateproduct")
    public String saveorUpdateProduct(@ModelAttribute(name="product")  Product product){//3
    	productService.saveOrUpdateProduct(product); //insert and update
    	return "redirect:/all/getallproducts";
	
			
			
			
			
			
			
			
}
}

