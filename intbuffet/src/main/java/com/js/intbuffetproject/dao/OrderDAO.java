package com.js.intbuffetproject.dao;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.model.Order;

public interface OrderDAO {

	void addOrder(Order order);

	List<Order> listOrder();
	
	List<Order> listOrderFromTo(Date from, Date to);
	
	List<Order> listOrderByClient(String username);
	
	Order getOrderById(Long id);

	void removeOrder(Long id);
}