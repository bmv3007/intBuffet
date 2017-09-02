package com.js.intbuffetproject.service;

import java.io.Serializable;
import java.util.List;

import com.js.intbuffetproject.model.Address;

/**
 * @see AddressServiceImpl
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public interface AddressService {

	Serializable addAddress(Address category);

	List<Address> listAddresses();
	
	Address getAddressByID(Long id);

	void removeAddress(Long id);
	
	Address findAddress(Address address);
	
	List<String> listCountries();
	
	List<String> listCities();
	
	List<String> listStreets();
	
}