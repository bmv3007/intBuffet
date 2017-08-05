package com.js.intbuffetproject.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.StatisticDAO;
import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;

@Repository
public class StatisticDAOImpl implements StatisticDAO {

	private static final Logger logger = Logger.getLogger(StatisticDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getTopProducts() {
		List<Product> listPr = sessionFactory.getCurrentSession().createQuery("from Product ORDER BY name ASC").list();

		return listPr;
	}

	@Override
	public List<Object[]> getTopClients() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.groupProperty("user"));
		projectionList.add(Projections.sum("ordertotal").as("ordertotal"));
		criteria.setProjection(projectionList).addOrder(org.hibernate.criterion.Order.desc("ordertotal"));
		criteria.setMaxResults(10);
		// criteria.setProjection(Projections.sum("ordertotal"));

		// Query query = (Query)
		// sessionFactory.getCurrentSession().createQuery("select order.user,
		// sum(order.ordertotal) from Order order group by order.user");

		// Criteria criteria = session.createCriteria(StockDailyRecord.class);
		// criteria.setMaxResults(10);
		// criteria.setFirstResult(20);
		logger.info("criteria.list() = " + criteria.list());
		List listOrders = criteria.list();
		logger.info(listOrders.size());
		/*
		 * for(Iterator<Object[]> it = listOrders.iterator(); it.hasNext()){
		 * Object[] obj= (Object[]) it.next(); logger.info("listOrders = "+
		 * obj[1]); }
		 */
		// logger.info("listOrders = "+ ( (Object[]) listOrders.get(1))[1]);
		return listOrders;
	}

	@Override
	public List<Order> getRevenue(Date from, Date to) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		List<Order> orders = criteria.add(Restrictions.between("date", from, to)).list();

		return orders;

	}

}