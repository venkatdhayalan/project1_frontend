package com.sports.dao;

import com.sports.model.Cart;
import com.sports.model.CartItem;
import com.sports.model.CustomerOrder;

public interface CartItemDao {
	
	void SaveOrUpdateCartItem(CartItem cartItem);
	
	void removeCartItem(int cartItemId);
	
	Cart getCart(int cartId);
	
	CustomerOrder createOrder(Cart cart);

}
