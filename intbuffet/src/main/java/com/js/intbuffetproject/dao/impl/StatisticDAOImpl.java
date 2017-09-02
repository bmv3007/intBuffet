package com.js.intbuffetproject.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.StatisticDAO;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;

@Repository
public class StatisticDAOImpl implements StatisticDAO {

	private static final Logger LOG = Logger.getLogger(StatisticDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getTopProducts() {
		List<Product> listPr = sessionFactory.getCurrentSession().createQuery("from Product ORDER BY sell_quantity DESC").setMaxResults(5).list();

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

		List<Object[]> listOrders = criteria.list();

		return listOrders;
	}

	@Override
	public List<Order> getRevenue(Date from, Date to) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		List<Order> orders = criteria.add(Restrictions.and(Restrictions.between("date", from, to), Restrictions.eq("cart", false))).list();

		return orders;

	}

}