package com.js.intbuffetproject.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.OrderDAO;
import com.js.intbuffetproject.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger LOG = Logger.getLogger(OrderDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addOrder(Order order) {

		 sessionFactory.getCurrentSession().save(order);

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Order> listOrder() {

		ArrayList<Order> listPr = (ArrayList<Order>) sessionFactory.getCurrentSession()
				.createQuery("from Order where ordertotal>0 ORDER BY date, id ASC").list();

		return listPr;
	}

	public void removeOrder(Long id) {
		Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, id);
		if (null != order) {
			sessionFactory.getCurrentSession().delete(order);
		}

	}

	public void removeCart(String username) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.createAlias("user", "client")
				.add(Restrictions.and(Restrictions.eq("client.username", username), Restrictions.eq("cart", true)));

		List<Order> list = criteria.list();

		if (!list.isEmpty()) {
			for (Order order : list) {

				Order orderToDelete = (Order) sessionFactory.getCurrentSession().get(Order.class, order.getId());
				if (null != orderToDelete) {
					Query query = session
							.createSQLQuery("DELETE FROM orders_products WHERE orders_id=" + orderToDelete.getId());
					query.executeUpdate();
					session.delete(orderToDelete);
				}

			}
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
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		criteria.createAlias("user", "client").add(Restrictions.and(Restrictions.eq("client.username", username), Restrictions.eq("cart", false)));
		//criteria.add(Restrictions.eq("cart", false));
		List<Order> orders = criteria.list();

		return orders;
	}

	@Override
	public Order getOrderById(Long id) {
		Order order = (Order) sessionFactory.getCurrentSession().get(Order.class, id);
		return order;
	}

	@Override
	public Order getCartByUsername(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		criteria.createAlias("user", "client")
				.add(Restrictions.and(Restrictions.eq("client.username", username), Restrictions.eq("cart", true)));

		List<Order> list = criteria.list();

		if (!list.isEmpty()) {
			Order orders = (Order) criteria.list().get(0);

			return orders;
		} else
			return null;
	}

	@Override
	public void updateOrder(Order order) {

		sessionFactory.getCurrentSession().update(order);

	}

}