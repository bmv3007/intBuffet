package com.js.intbuffetproject.service;

import java.util.List;

import com.js.intbuffetproject.model.Product;


public interface ProductService {

	public void addProduct(Product product);

	public List<Product> listProduct();
	
	public Product getProductByID(Long id);

	// @Secured("{ROLE_ADMIN}")
	public void removeProduct(Long id);
	
	public List<Product> searchProduct(String searchtext);
}