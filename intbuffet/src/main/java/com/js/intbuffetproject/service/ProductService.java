package com.js.intbuffetproject.service;

import java.util.Collection;
import java.util.List;

import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.OrdersProducts;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.SearchParameter;


public interface ProductService {

	void addProduct(Product product);

	List<Product> listProduct();
	
	List<OrdersProducts> fillProducts(Collection<Item> collection);
	
	Product getProductByID(Long id);

	void removeProduct(Long id);
	
	List<Product> searchProduct(String searchtext);
	
	List<Product> searchProductByParameters(Long categoryId, boolean vegetarian);
	
	List<Integer> fillQuantities(Collection<Item> items);
}