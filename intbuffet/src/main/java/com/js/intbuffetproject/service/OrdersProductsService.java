package com.js.intbuffetproject.service;

import java.util.List;

import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.OrdersProducts;

public interface OrdersProductsService {

	boolean saveOrdersProducts(OrdersProducts ordersProducts);
	
	boolean saveOrdersProductsAll(List<OrdersProducts> ordersProductsList);
	
	void setOrder(List<OrdersProducts> ordersProductsList, Order order);

}