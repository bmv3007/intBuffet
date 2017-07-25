package com.js.intbuffetproject.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.CategoryDAO;
import com.js.intbuffetproject.dao.ProductDAO;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static final Logger logger = Logger.getLogger(CategoryDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Category> listCategories() {

		// if (logger.isDebugEnabled()) {
		// logger.debug("getWelcome is executed!");
		// }

		// logs exception
		// logger.error("This is Error message", new Exception("Testing"));
		ArrayList<Category> listCategories = (ArrayList<Category>) sessionFactory.getCurrentSession()
				.createQuery("from Category ORDER BY name ASC").list();
		for (Category cat : listCategories) {
			System.out.println(cat.getName());
		}
		return listCategories;
	}

	public void removeCategory(Long id) {
		Category category = (Category) sessionFactory.getCurrentSession().load(Category.class, id);
		if (null != category) {
			sessionFactory.getCurrentSession().delete(category);
		}

	}

	@Override
	public Category getCategoryByID(Long id) {
		// TODO Auto-generated method stub
		return (Category) sessionFactory.getCurrentSession().load(Category.class, id);
	}

	
}