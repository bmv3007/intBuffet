package com.js.intbuffetproject.service;

import com.js.intbuffetproject.model.Cart;

public interface CartService {

	Cart addToCart(Cart cart, Long id);

	Cart creatNewCart(Long id);

	Cart removeFromCart(Cart cart, Long id);

	Cart removeItemFromCart(Cart cart, Long id);

}