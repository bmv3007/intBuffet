package com.js.intbuffetproject.dao;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.model.Order;

public interface OrderDAO {

	public void addOrder(Order order);

	public List<Order> listOrder();
	
	public List<Order> listOrderFromTo(Date from, Date to);
	
	public List<Order> listOrderByClient(String username);
	
	public Order getOrderById(Long id);

	public void removeOrder(Integer id);
}