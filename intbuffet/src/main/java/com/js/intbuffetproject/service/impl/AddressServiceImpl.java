package com.js.intbuffetproject.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.AddressDAO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;

	@Transactional
	public Serializable addAddress(Address address) {
		Serializable idAddress =  addressDAO.addAddress(address);
		 return idAddress;
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
		// TODO Auto-generated method stub
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