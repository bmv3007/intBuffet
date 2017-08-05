package com.js.intbuffetproject.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cart {
     
	private Long id;
	private User user;
	private double total;
	private Integer totalItems;
	private Map<Long, Item> productsInCart = new ConcurrentHashMap<Long, Item>(); // product-quantity

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

	public Cart(User user, double total, Map<Long, Item> productsInCart) {
		super();
		this.user = user;
		this.total = total;
		this.productsInCart = productsInCart;
	}
	
	

	public Cart(User user, double total, Integer totalItems, Map<Long, Item> productsInCart) {
		super();
		this.user = user;
		this.total = total;
		this.totalItems = totalItems;
		this.productsInCart = productsInCart;
	}
	
	

	public Cart(Long id, User user, double total, Integer totalItems, Map<Long, Item> productsInCart) {
		super();
		this.id = id;
		this.user = user;
		this.total = total;
		this.totalItems = totalItems;
		this.productsInCart = productsInCart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addProduct(Long itemId, Item item) {

		productsInCart.put(itemId, item);
	}

	public void deleteProduct(Long id) {
		productsInCart.remove(id);
	}

	public double getTotal() {
		
		if(productsInCart!=null){
			total = 0.0;
			for(Item item:productsInCart.values()){
				total = total + (double) (item.getPrice()*item.getQuantity());
			}
		}
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getTotalItems() {
		
		if(productsInCart!=null){
			totalItems = 0;
			for(Item item:productsInCart.values()){
				totalItems = totalItems + 1;
			}
		}
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	
	

}
