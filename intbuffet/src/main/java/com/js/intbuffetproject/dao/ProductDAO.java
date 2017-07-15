package com.js.intbuffetproject.dao;

import java.util.List;

import com.js.intbuffetproject.model.Product;

public interface ProductDAO {

	public void addProduct(Product product);

	public List<Product> listProduct();

	public void removeProduct(Integer id);
}