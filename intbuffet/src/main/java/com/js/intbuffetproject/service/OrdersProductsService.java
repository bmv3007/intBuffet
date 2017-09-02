package com.js.intbuffetproject.service;

import java.util.List;

import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.OrdersProducts;

/**
 * @see com.js.intbuffetproject.service.impl.OrdersProductsServiceImpl
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public interface OrdersProductsService {

	boolean saveOrdersProducts(OrdersProducts ordersProducts);
	
	boolean saveOrdersProductsAll(List<OrdersProducts> ordersProductsList);
	
	void setOrder(List<OrdersProducts> ordersProductsList, Order order);

}