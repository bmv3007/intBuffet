package com.js.intbuffetproject.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.StatisticDAO;
import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.StatisticService;
import com.js.intbuffetproject.util.TopClient;

/**
 * Class StatisticServiceImpl is used to get statistic.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

	private static final Logger LOG = Logger.getLogger(StatisticServiceImpl.class);

	@Autowired
	private StatisticDAO statisticDAO;

	@Autowired
	private ProductService productService;

	@Override
	public List<Product> getTopProducts() {

		return statisticDAO.getTopProducts();
	}

	@Override
	public List<TopClient> getTopClients() {

		List<Object[]> topClientObject = statisticDAO.getTopClients();
		List<TopClient> listTopClient = null;
		if (!topClientObject.isEmpty()) {
			listTopClient = new ArrayList<>();
			for (Object[] object : topClientObject) {
				TopClient topClient = new TopClient();
				StringBuffer name = new StringBuffer();
				name.append(((User) object[0]).getFirstname()).append(" ").append(((User) object[0]).getSurname());
				topClient.setUser(name.toString());
				topClient.setSum((Double) object[1]);
				listTopClient.add(topClient);

			}
		}
		return listTopClient;
	}

	@Override
	public String getRevenue(Date from, Date to) {
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(to);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		to = calendar.getTime();

		List<Order> listOrders = statisticDAO.getRevenue(from, to);
		Double sum = 0.0;
		for (Order order : listOrders) {
			sum = sum + order.getOrdertotal();

		}

		return sum.toString();
	}

	@Override
	public List<ProductDTO> getTopProductsDTO() {

		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for (Product product : getTopProducts()) {
			list.add(productService.converterProductDTO(product));
		}
		return list;
	}

}