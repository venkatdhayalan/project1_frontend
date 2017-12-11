package com.sports.services;

import com.sports.model.Cart;
import com.sports.model.CartItem;
import com.sports.model.CustomerOrder;

public interface CartItemService {

	void saveOrUpdateCartItem(CartItem cartItem);
	
	void removeCartItem(int cartItemId);
	
	Cart getCart(int cartId);
	
	CustomerOrder createOrder(Cart cart);
}


