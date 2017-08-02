package com.js.intbuffetproject.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.OrderDAO;
import com.js.intbuffetproject.dao.impl.OrderDAOImpl;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public boolean addOrder(Order order) {
		logger.info("====addOrder=====");
		
			orderDAO.addOrder(order);
			return true;
		

	}

	@Override
	public void editOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getOrderByUsername(String username) {
		// TODO Auto-generated method stub
		return orderDAO.listOrderByClient(username);
	}

	@Override
	public void removeOrder(Long id) {

		orderDAO.removeOrder(id);
		
	}

	@Override
	public List<Order> listOrder() {
		// TODO Auto-generated method stub
		return orderDAO.listOrder();
	}

	@Override
	public List<Order> listOrderFromTo(Date from, Date to) {
		// TODO Auto-generated method stub
		return orderDAO.listOrderFromTo(from, to);
	}

	@Override
	public List<Order> listOrderByClient(String username) {
		// TODO Auto-generated method stub
		return orderDAO.listOrderByClient(username);
	}

	

}