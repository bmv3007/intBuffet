package com.js.intbuffetproject.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.AddressDAO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.service.AddressService;

/**
 * Class AddressServiceImpl contains business logic related to class Address.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;

	@Transactional
	public Serializable addAddress(Address address) {
				
		return addressDAO.addAddress(address);
	}

	@Transactional
	public Address findAddress(Address address) {
		return addressDAO.findAddress(address);
	}

	@Transactional
	public List<Address> listAddresses() {

		return addressDAO.listAddresses();
	}

	@Transactional
	public void removeAddress(Long id) {
		addressDAO.removeAddress(id);
	}

	@Override
	public Address getAddressByID(Long id) {
	
		return addressDAO.getAddressByID(id);
	}

	@Override
	public List<String> listCountries() {

		return addressDAO.listCountries();
	}

	@Override
	public List<String> listCities() {

		return addressDAO.listCities();
	}

	@Override
	public List<String> listStreets() {

		return addressDAO.listStreets();
	}

}