package com.js.intbuffetproject.dao;

import java.util.List;

import com.js.intbuffetproject.model.Product;

public interface ProductDAO {

	public void addProduct(Product product);

	public List<Product> listProduct();

	public void removeProduct(Long id);
	
	public Product getProductByID(Long id);
	
	public List<Product> searchProduct(String searchtext);
}