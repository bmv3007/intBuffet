package com.js.intbuffetproject.model;

import java.util.Hashtable;

public class Cart {
	
	private User user;
	private Hashtable<Product,Integer> productsInCart = new Hashtable<>(); //product-quantity
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hashtable<Product, Integer> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(Hashtable<Product, Integer> productsInCart) {
		this.productsInCart = productsInCart;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(User user, Hashtable<Product, Integer> productsInCart) {
		super();
		this.user = user;
		this.productsInCart = productsInCart;
	}

	public void addProduct(Product product, Integer amount){
		productsInCart.put(product, amount);
	}
	
	public void deleteProduct(Product product){
		productsInCart.remove(product);
	}
	

}
