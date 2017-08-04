package com.js.intbuffetproject.dao;

import java.io.Serializable;
import java.util.List;

import com.js.intbuffetproject.model.Address;

public interface AddressDAO {

	Serializable addAddress(Address address);

	void removeAddress(Long id);
	
	List<Address> listAddresses();
	
	Address getAddressByID(Long id);
	
	Address findAddress(Address address);
	
	List<String> listCountries();
	List<String> listCities();
	List<String> listStreets();

	
	
}