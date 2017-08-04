package com.js.intbuffetproject.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
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
	//	List listUser = .createQuery("user, sum(ordertotal) total from Order GROUP BY user ORDER BY total ASC").list();
		
		Query query = (Query) sessionFactory.getCurrentSession().createQuery("select order.user, sum(order.ordertotal)"
				+ " from Order order group by order.user");
		
		//Criteria criteria = session.createCriteria(StockDailyRecord.class);
		//criteria.setMaxResults(10);
		//criteria.setFirstResult(20);
		List<Object[]> groupList = query.getResultList();
		for(Object[] arr : groupList){
			System.out.println(Arrays.toString(arr));
		}
		
		return groupList;
	}

	@Override
	public List<Order> getRevenue(Date from, Date to) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		List<Order> orders = criteria.add(Restrictions.between("date", from, to)).list();

		return orders;

	}

}