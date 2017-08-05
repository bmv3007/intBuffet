package com.js.intbuffetproject.service;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.util.TopClient;


public interface StatisticService {

	List<Product> getTopProducts();
	
	List<TopClient> getTopClients();

	double getRevenue(Date from, Date to);
		
	
}