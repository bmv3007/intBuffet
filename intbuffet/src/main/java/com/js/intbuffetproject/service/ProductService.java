package com.js.intbuffetproject.service;

import java.util.Collection;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.OrdersProducts;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.SearchParameter;


public interface ProductService {

	void addProduct(Product product, Category category, MultipartFile file);

	List<Product> listProduct();
	
	List<OrdersProducts> fillProducts(Collection<Item> collection);
	
	Product getProductByID(Long id);

	void removeProduct(Long id);
	
	List<Product> searchProduct(String searchtext);
	
	List<Product> searchProductByParameters(Long categoryId, boolean vegetarian);
	
	List<Integer> fillQuantities(Collection<Item> items);
}