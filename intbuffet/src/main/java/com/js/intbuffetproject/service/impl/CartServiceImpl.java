package com.js.intbuffetproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.CartService;
import com.js.intbuffetproject.service.ProductService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductService productService;

	@Override
	public Cart addToCart(Cart cart, Long id) {
		Integer quantity = 0;
		if (cart.getProductsInCart().containsKey(id)) {

			Item item = cart.getProductsInCart().get(id);
			quantity = (Integer) cart.getProductsInCart().get(id).getQuantity() + 1;
			item.setQuantity(quantity);

			cart.addProduct(id, item);

		} else {
			Product product = productService.getProductByID(id);
			Item item = new Item(id, product.getName(), product.getDescription(), product.getPrice(), 1);
			cart.addProduct(id, item);
		}

		return cart;

	}

	@Override
	public Cart removeFromCart(Cart cart, Long id) {

		if (cart.getProductsInCart().containsKey(id)) {
			Item item = cart.getProductsInCart().get(id);
			Integer quantity = (Integer) cart.getProductsInCart().get(id).getQuantity();
			if (quantity > 0) {
				--quantity;
				item.setQuantity(quantity);
			}
		}
		return cart;

	}

	@Override
	public Cart creatNewCart(Long id) {

		Product product = productService.getProductByID(id);

		Cart cart = new Cart();
		Item item = new Item(id, product.getName(), product.getDescription(), product.getPrice(), 1);
		cart.addProduct(id, item);

		return cart;

	}

	@Override
	public Cart removeItemFromCart(Cart cart, Long id) {

		if (cart.getProductsInCart().containsKey(id)) {
			cart.getProductsInCart().remove(id);
			cart.setTotal(cart.getTotal());
		}
		return cart;
	}

}