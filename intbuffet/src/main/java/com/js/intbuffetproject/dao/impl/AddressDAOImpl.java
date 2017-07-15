package com.js.intbuffetproject.dao.impl;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.intbuffetproject.dao.AddressDAO;
import com.js.intbuffetproject.model.Address;


@Repository
public class AddressDAOImpl implements AddressDAO {

	private static final Logger logger = Logger.getLogger(AddressDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addAddress(Address address) {
		sessionFactory.getCurrentSession().save(address);
	}

	public void removeAddress(Long id) {
		Address address = (Address) sessionFactory.getCurrentSession().load(Address.class, id);
		if (null != address) {
			sessionFactory.getCurrentSession().delete(address);
		}

	}

}