package com.js.intbuffetproject.dao;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;

public interface StatisticDAO {

	List<Product> getTopProducts();

	List<Object[]> getTopClients();

	List<Order> getRevenue(Date from, Date to); 
	
}