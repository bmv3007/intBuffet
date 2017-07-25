package com.js.intbuffetproject.service;

import java.util.List;

import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.SearchParameter;


public interface ProductService {

	void addProduct(Product product);

	List<Product> listProduct();
	
	Product getProductByID(Long id);

	void removeProduct(Long id);
	
	List<Product> searchProduct(String searchtext);
	
	List<Product> searchProductByParameters(SearchParameter searchParameter);
}