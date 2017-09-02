package com.js.intbuffetproject.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.js.intbuffetproject.dao.OrdersProductsDAO;
import com.js.intbuffetproject.model.OrdersProducts;

@Repository
public class OrdersProductsDAOImpl implements OrdersProductsDAO {

	private static final Logger LOG = Logger.getLogger(OrdersProductsDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrdersProducts(OrdersProducts ordersProducts) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ordersProducts);
	}

}