package com.js.intbuffetproject.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.ProductDAO;
import com.js.intbuffetproject.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static final Logger logger = Logger.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Product> listProduct() {

		// if (logger.isDebugEnabled()) {
		// logger.debug("getWelcome is executed!");
		// }

		// logs exception
		// logger.error("This is Error message", new Exception("Testing"));
		ArrayList<Product> listPr = (ArrayList<Product>) sessionFactory.getCurrentSession()
				.createQuery("from Product ORDER BY name ASC").list();
		for (Product pr : listPr) {
			System.out.println(pr.getName());
		}
		return listPr;
	}

	public void removeProduct(Integer id) {
		Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
		if (null != product) {
			sessionFactory.getCurrentSession().delete(product);
		}

	}

}