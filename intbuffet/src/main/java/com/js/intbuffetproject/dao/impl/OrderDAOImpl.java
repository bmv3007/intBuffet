package com.js.intbuffetproject.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.OrderDAO;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger logger = Logger.getLogger(OrderDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Order> listOrder() {

		// if (logger.isDebugEnabled()) {
		// logger.debug("getWelcome is executed!");
		// }

		// logs exception
		// logger.error("This is Error message", new Exception("Testing"));
		ArrayList<Order> listPr = (ArrayList<Order>) sessionFactory.getCurrentSession()
				.createQuery("from Order ORDER BY id ASC").list();
		for (Order pr : listPr) {
			System.out.println(pr.getId());
		}
		return listPr;
	}

	public void removeOrder(Integer id) {
		Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, id);
		if (null != order) {
			sessionFactory.getCurrentSession().delete(order);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> listOrderFromTo(Date from, Date to) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		List<Order> orders = criteria.add(Restrictions.between("date", from, to)).list();

		return orders;

	}

	@Override
	public List<Order> listOrderByClient(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(Long id) {
		Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, id);
		return order;
	}

}