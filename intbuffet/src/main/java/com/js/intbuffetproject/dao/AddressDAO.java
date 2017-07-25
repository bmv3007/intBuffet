package com.js.intbuffetproject.dao;

import com.js.intbuffetproject.model.Address;

public interface AddressDAO {

	void addAddress(Address address);

	void removeAddress(Long id);
}