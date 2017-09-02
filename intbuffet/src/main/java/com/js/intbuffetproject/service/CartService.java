package com.js.intbuffetproject.service;

import com.js.intbuffetproject.dto.Cart;

/**
 * @see com.js.intbuffetproject.service.impl.CartServiceImpl
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public interface CartService {

	Cart addToCart(Cart cart, Long id);

	Cart creatNewCart(Long id);

	Cart removeFromCart(Cart cart, Long id);

	Cart removeItemFromCart(Cart cart, Long id);

}