package com.js.intbuffetproject.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.OrdersProductsDAO;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.OrdersProducts;
import com.js.intbuffetproject.service.OrdersProductsService;

@Service
@Transactional
public class OrdersProductsServiceImpl implements OrdersProductsService {

	private static final Logger logger = Logger.getLogger(OrdersProductsServiceImpl.class);

	@Autowired
	private OrdersProductsDAO ordersProductsDAO;

	@Override
	public boolean saveOrdersProducts(OrdersProducts ordersProducts) {

		ordersProductsDAO.saveOrdersProducts(ordersProducts);
		return true;
	}

	@Override
	public boolean saveOrdersProductsAll(List<OrdersProducts> ordersProductsList) {

		for (OrdersProducts item : ordersProductsList) {
			saveOrdersProducts(item);
		}
		return true;
	}

	@Override
	public void setOrder(List<OrdersProducts> ordersProductsList, Order order) {
		
		for (OrdersProducts item : ordersProductsList) {
			item.setOrder(order);
		}
	}

}