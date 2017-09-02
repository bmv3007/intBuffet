package com.js.intbuffetproject.dao;

import java.util.List;

import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.util.SearchParameter;

public interface ProductDAO {

	void addProduct(Product product);

	List<Product> listProduct();

	void removeProduct(Long id);
	
	Product getProductByID(Long id);
	
	List<Product> searchProduct(String searchtext);
	
	public List<Product> searchProductByParameters(SearchParameter searchParameter);
	
	void updateSellQuantity(Product product, int sellQuantity);
}