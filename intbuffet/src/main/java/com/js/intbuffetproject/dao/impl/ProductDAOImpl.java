package com.js.intbuffetproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.ProductDAO;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.SearchParameter;

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

		ArrayList<Product> listPr = (ArrayList<Product>) sessionFactory.getCurrentSession()
				.createQuery("from Product ORDER BY name ASC").list();

		return listPr;
	}

	public void removeProduct(Long id) {
		Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
		if (null != product) {
			sessionFactory.getCurrentSession().delete(product);
		}

	}

	@Override
	public Product getProductByID(Long id) {
		
		return (Product) sessionFactory.getCurrentSession().load(Product.class, id);
	}

	@Override
	public List<Product> searchProduct(String searchtext) {

		if (searchtext.trim().isEmpty())
			return listProduct();
		else {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
			List<Product> products = criteria.add(Restrictions.like("name", "%" + searchtext + "%")).list();

			return products;
		}

	}

	@Override
	public List<Product> searchProductByParameters(SearchParameter searchParameter) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		if (searchParameter.getCategoryID() != 0) {
			criteria.createAlias("category", "category")
					.add(Restrictions.eq("category.id", searchParameter.getCategoryID()));
		}

		if (searchParameter.getVegetarian() == true) {
			criteria.add(Restrictions.eq("vegetarian", true));
		}

		List<Product> products = criteria.list();

		return products;
	}

	@Override
	public void updateSellQuantity(Product product, Integer sellQuantity) {
		product.setSell_quantity(sellQuantity);
		
			sessionFactory.getCurrentSession().update(product);
	

	}

}