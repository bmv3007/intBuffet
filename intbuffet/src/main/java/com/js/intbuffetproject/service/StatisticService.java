package com.js.intbuffetproject.service;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Product;




public interface StatisticService {

	List<Product> getTopProducts();
	
	List<Object[]> getTopClients();

	double getRevenue(Date from, Date to);
		
	
}