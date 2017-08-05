package com.js.intbuffetproject.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.StatisticDAO;
import com.js.intbuffetproject.dao.impl.StatisticDAOImpl;
import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.StatisticService;
import com.js.intbuffetproject.util.TopClient;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {
 
	private static final Logger logger = Logger.getLogger(StatisticServiceImpl.class);

	
	@Autowired
	private StatisticDAO statisticDAO;
	

	@Override
	public List<Product> getTopProducts() {
		
		return statisticDAO.getTopProducts();
	}

	@Override
	public List<TopClient> getTopClients() {
		
		List<Object[]> topClientObject =  statisticDAO.getTopClients();
		List<TopClient> listTopClient = null;
		if(!topClientObject.isEmpty()){
		listTopClient = new ArrayList<>();
		for(Object[] object:topClientObject){
			TopClient topClient = new TopClient();
			StringBuffer name = new StringBuffer();
			name.append(((User) object[0]).getFirstname()).append(" ").append(((User) object[0]).getSurname());
			topClient.setUser(name.toString());
			topClient.setSum((Double) object[1]);
			listTopClient.add(topClient);
			//logger.info("Object ***************** "+((User) object[0]).getFirstname() +"----"+object[1]);
		}
		}
     return listTopClient;
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