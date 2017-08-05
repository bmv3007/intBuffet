package com.js.intbuffetproject.dao.impl;

import java.io.Serializable;
import java.util.List;

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

	public Serializable addAddress(Address address) {
		Serializable idAddress = sessionFactory.getCurrentSession().save(address);
		return idAddress;
	}

	public void removeAddress(Long id) {
		Address address = (Address) sessionFactory.getCurrentSession().load(Address.class, id);
		if (null != address) {
			sessionFactory.getCurrentSession().delete(address);
		}

	}

	@Override
	public List<Address> listAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddressByID(Long id) {
		
		return  (Address) sessionFactory.getCurrentSession().get(Address.class, id);
	}

	@Override
	public List<String> listCountries() {

		return (List<String>) sessionFactory.getCurrentSession().createSQLQuery("select distinct country from addresses order by country").list();
	}

	@Override
	public List<String> listCities() {
		
		return (List<String>) sessionFactory.getCurrentSession().createSQLQuery("select distinct city from addresses order by city").list();
	}

	@Override
	public List<String> listStreets() {
		
		return (List<String>) sessionFactory.getCurrentSession().createSQLQuery("select distinct street from addresses order by street").list();
	}

	@Override
	public Address findAddress(Address address) {
		
		return null;
	}

}