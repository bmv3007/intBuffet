package com.js.intbuffetproject.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.UserDAO;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		logger.info("Birthday" + user.getBirthday());
		sessionFactory.getCurrentSession().save(user);
	}

	public void removeUser(String username) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, username);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}

	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByUsername(String username) {

		return (User) sessionFactory.getCurrentSession().load(User.class, username);
	}

}