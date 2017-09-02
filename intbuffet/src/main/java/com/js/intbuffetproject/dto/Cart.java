package com.js.intbuffetproject.dto;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.User;

/**
 * Class Cart with properties <b>id</b>, <b>user</b>, <b>total</b>,
 * <b>totalItems</b>, <b>productsInCart</b>. 
 * It's used for storing products by shopping.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
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

	}

	public Cart(User user, Map<Long, Item> productsInCart) {
		super();
		this.user = user;
		this.productsInCart = productsInCart;
	}

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

		if (productsInCart != null) {
			total = 0.0;
			for (Item item : productsInCart.values()) {
				total = total + (double) (item.getPrice() * item.getQuantity());
			}
		}
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getTotalItems() {

		if (productsInCart != null) {
			totalItems = 0;
			for (Item item : productsInCart.values()) {
				totalItems = totalItems + 1;
			}
		}
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

}
