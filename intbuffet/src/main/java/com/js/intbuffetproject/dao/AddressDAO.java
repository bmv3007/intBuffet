package com.js.intbuffetproject.dao;

import com.js.intbuffetproject.model.Address;

public interface AddressDAO {

	public void addAddress(Address address);

	public void removeAddress(Long id);
}