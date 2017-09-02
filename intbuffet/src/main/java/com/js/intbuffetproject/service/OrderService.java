package com.js.intbuffetproject.service;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.dto.Cart;
import com.js.intbuffetproject.dto.OrderDTO;
import com.js.intbuffetproject.model.Order;

/**
 * @see com.js.intbuffetproject.service.impl.OrderServiceImpl
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public interface OrderService {

	boolean addOrder(Order order);
	
	Order getOrderById(Long id);

	void updateOrder(Order order);

	List<Order> getOrderByUsername(String username);
	
	Cart getCartByUsername(String username);

	void removeOrder(Long id);
	
	void removeCart(String username);

	List<Order> listOrder();

	List<Order> listOrderFromTo(Date from, Date to);

	List<Order> listOrderByClient(String username);
	
	OrderDTO copyOrder(Long id);

}