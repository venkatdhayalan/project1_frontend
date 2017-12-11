package com.sports.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.model.Cart;
import com.sports.model.CartItem;
import com.sports.model.Customer;
import com.sports.model.CustomerOrder;
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void SaveOrUpdateCartItem(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		
	}
	public void removeCartItem(int cartItemId) {
		Session session=sessionFactory.getCurrentSession();
	    //select * from cartitem where id=?
	    CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
	    //delete from cartitem where id=?
	    session.delete(cartItem);
		
	}
	public Cart getCart(int cartId) {

		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart)session.get(Cart.class, cartId);
		//select records both from parent and child table , fetchType.EAGER
		return cart;
	}
	public CustomerOrder createOrder(Cart cart) {
		
		Session session=sessionFactory.getCurrentSession();
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setPurchaseDate(new Date());
		List<CartItem> cartItems=cart.getCartItems();
		double grandTotal=0;
		for(CartItem cartItem:cartItems){
			grandTotal=cartItem.getTotalPrice() + grandTotal;
		}
		
		cart.setGrandTotal(grandTotal);//update grandtotal column in cart
		customerOrder.setCart(cart);//FK cart_id
		Customer customer=cart.getCustomer();
		customerOrder.setCustomer(customer);//FK customer_id
		customerOrder.setBillingAddress(customer.getBillingaddress());//FK billingaddress_id
		customerOrder.setShippingAddress(customer.getShippingaddress());//FK shipping Address Id
		session.save(customerOrder);
		
		return customerOrder;
	}
	
	
}
