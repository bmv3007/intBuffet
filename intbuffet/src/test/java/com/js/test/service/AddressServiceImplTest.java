package com.js.test.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.js.intbuffetproject.dao.impl.AddressDAOImpl;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.service.impl.AddressServiceImpl;

public class AddressServiceImplTest {

	@Mock
	private AddressDAOImpl addressDAOImpl = new AddressDAOImpl();

	@InjectMocks
	private AddressServiceImpl addressServiceImpl = new AddressServiceImpl();

	private Address address;
	
	private Address addressNotExist;

	//Map<Long, Address> addressMap = new HashMap<Long, Address>();
	
	List<String> listCountries = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		address = new Address(3260689382642549142L, "Russia", "Moscow", "123588", "Tverskaya", "10", 25);
		addressNotExist = new Address(3260689382642549148L, "Russia", "Moscow", "123588", "Tverskaya", "10", 25);

	/*	Address address1 = new Address(3260689382642549143L, "Russia", "Moscow", "123588", "Tverskaya", "10", 15);
		Address address2 = new Address(3260689382642549144L, "Russia", "Moscow", "123588", "Tverskaya", "10", 85);

		addressMap.put(3260689382642549143L, address1);
		addressMap.put(3260689382642549144L, address2);*/
		
		listCountries.add("Russia");
		
		
		

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAddress() {

		when(addressDAOImpl.findAddress(address)).thenReturn(address);

		Address addressFound = addressServiceImpl.findAddress(address);

		Assert.assertEquals(addressFound, address);

	}
	
	@Test
	public void testFindAddressFail() {

		when(addressDAOImpl.findAddress(addressNotExist)).thenReturn(null);

		Address addressFound = addressServiceImpl.findAddress(addressNotExist);

		Assert.assertNull(addressFound);

	}

	@Test
	public void testAddAddress() {

		when(addressDAOImpl.addAddress(address)).thenReturn(3260689382642549142L);

		long addressAddedId = (long) addressServiceImpl.addAddress(address);

		Assert.assertEquals(addressAddedId, 3260689382642549142L);

	}

	@Test
	public void testGetAddressByID() {

		when(addressDAOImpl.getAddressByID(3260689382642549142L)).thenReturn(address);

		Address addressById = addressServiceImpl.getAddressByID(address.getId());

		Assert.assertEquals(addressById, address);

	}
	
	
	@Test
	public void testGetAddressByIDFail() {

		when(addressDAOImpl.getAddressByID(3260689382642549148L)).thenReturn(null);

		Address addressById = addressServiceImpl.getAddressByID(addressNotExist.getId());

		Assert.assertNull(addressById);

	}

	@Test
	public void testListCountries() {

		when(addressDAOImpl.listCountries()).thenReturn(listCountries);

		List<String> listCountriesFound =  addressServiceImpl.listCountries();

		Assert.assertEquals(listCountriesFound, listCountries);

	}

}
