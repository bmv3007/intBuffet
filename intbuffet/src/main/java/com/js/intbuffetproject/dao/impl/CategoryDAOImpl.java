package com.js.intbuffetproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.CategoryDAO;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Product;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static final Logger LOG = Logger.getLogger(CategoryDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addCategory(Category category){
		sessionFactory.getCurrentSession().save(category);
	}

	public void updateCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}
	
	public void updateNameCategory(String name, Long id){
		
		Category categoryOld = getCategoryByID(id);
		categoryOld.setName(name);
		updateCategory(categoryOld);
		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Category> listCategories() {

		ArrayList<Category> listCategories = (ArrayList<Category>) sessionFactory.getCurrentSession()
				.createQuery("from Category ORDER BY name ASC").list();

		return listCategories;
	}

	public void removeCategory(Long id) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
		if (null != category) {
			sessionFactory.getCurrentSession().delete(category);
		}

	}

	@Override
	public Category getCategoryByID(Long id) {

		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}
	
	@Override
	public List<Category> getCategoryByName(String name) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		List<Category> category = criteria.add(Restrictions.eq("name", name)).list();
        LOG.info("Category exists!");
		return category;

		
	}

}