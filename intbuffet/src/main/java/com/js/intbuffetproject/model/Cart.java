package com.js.intbuffetproject.model;

import java.util.Hashtable;
import java.util.Map;

public class Cart {

	private User user;
	private Map<Long, Item> productsInCart = new Hashtable<>(); // product-quantity

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<Long, Item> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(Map<Long, Item> productsInCart) {
		this.productsInCart = productsInCart;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(User user, Map<Long, Item> productsInCart) {
		super();
		this.user = user;
		this.productsInCart = productsInCart;
	}

	/*
	 * public void addProduct(Product product, Integer amount){
	 * productsInCart.put(product, amount); }
	 */

	public void addProduct(Long itemId, Item item) {

		productsInCart.put(itemId, item);
	}

	public void deleteProduct(Long id) {
		productsInCart.remove(id);
	}

}
