package com.js.intbuffetproject.service;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.util.TopClient;


public interface StatisticService {

	List<Product> getTopProducts();
	
	List<ProductDTO> getTopProductsDTO();
	
	List<TopClient> getTopClients();

	String getRevenue(Date from, Date to);
	
	
}