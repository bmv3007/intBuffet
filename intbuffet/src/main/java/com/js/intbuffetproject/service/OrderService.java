package com.js.intbuffetproject.service;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.User;

public interface OrderService {

	boolean addOrder(Order order);

	void editOrder(Order order);

	List<Order> getOrderByUsername(String username);

	void removeOrder(Long id);

	List<Order> listOrder();

	List<Order> listOrderFromTo(Date from, Date to);

	List<Order> listOrderByClient(String username);

}