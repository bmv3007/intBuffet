package com.js.intbuffetproject.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.StatisticDAO;
import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.StatisticService;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticDAO statisticDAO;
	

	@Override
	public List<Product> getTopProducts() {
		
		return statisticDAO.getTopProducts();
	}

	@Override
	public List<Object[]> getTopClients() {
		
		return statisticDAO.getTopClients();
	}

	@Override
	public double getRevenue(Date from, Date to) {
		 List<Order> listOrders = statisticDAO.getRevenue(from, to);
		 double sum = 0.0;
		 for(Order order:listOrders){
			 sum=sum+order.getOrdertotal();
		 }
		 
		return sum;
	}

}