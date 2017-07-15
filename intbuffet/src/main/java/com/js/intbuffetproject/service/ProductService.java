package com.js.intbuffetproject.service;

import java.util.List;

import com.js.intbuffetproject.model.Product;


public interface ProductService {

	public void addProduct(Product product);

	public List<Product> listProduct();

	// @Secured("{ROLE_ADMIN}")
	public void removeProduct(Integer id);
}