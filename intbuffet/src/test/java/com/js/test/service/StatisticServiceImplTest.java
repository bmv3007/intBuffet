package com.js.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.js.intbuffetproject.dao.StatisticDAO;
import com.js.intbuffetproject.dao.impl.StatisticDAOImpl;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.impl.AddressServiceImpl;
import com.js.intbuffetproject.service.impl.StatisticServiceImpl;
import com.js.intbuffetproject.util.TopClient;

public class StatisticServiceImplTest {

	@Mock
	StatisticDAOImpl statisticDAO = new StatisticDAOImpl();

	@InjectMocks
	private StatisticServiceImpl statisticServiceImpl = new StatisticServiceImpl();

	List<Product> listProducts = new ArrayList<>();

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		Product product1 = new Product();
		Product product2 = new Product();
		listProducts.add(product1);
		listProducts.add(product2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTopProducts() {

		when(statisticDAO.getTopProducts()).thenReturn(listProducts);

		List<Product> listProductsFound = statisticServiceImpl.getTopProducts();

		Assert.assertEquals(listProductsFound, listProducts);
	}

	@Test
	public void testGetTopClients() {

		List<Object[]> listTopClients = new ArrayList<Object[]>();
		User user1 = new User("login1", "Ivan", "Ivanov");
		User user2 = new User("login2", "Sergey", "Petrov");
		Object[] client1 = new Object[] { user1, 235.5 };
		Object[] client2 = new Object[] { user2, 285.5 };

		listTopClients.add(client1);
		listTopClients.add(client2);

		when(statisticDAO.getTopClients()).thenReturn(listTopClients);

		List<TopClient> listTopClient = statisticServiceImpl.getTopClients();

		Double sum = 0.0;

		for (TopClient topClient : listTopClient) {
			sum = sum + topClient.getSum();

		}

		Assert.assertEquals(sum, (Double) (235.5 + 285.5));
	}

	/*
	 * @Test public void testGetRevenue() {
	 * 
	 * Calendar calendar = new GregorianCalendar(2017, 8, 23, 00, 00, 00); Date
	 * from = calendar.getTime(); calendar.roll(Calendar.DAY_OF_MONTH, 1); Date
	 * to = calendar.getTime(); List<Order> listOrders = new ArrayList<>();
	 * Order order1 = new Order(); order1.setOrdertotal(256.0); Order order2 =
	 * new Order(); order2.setOrdertotal(124.8);
	 * 
	 * listOrders.add(order1); listOrders.add(order2);
	 * 
	 * when(statisticDAO.getRevenue(from, to)).thenReturn(listOrders);
	 * 
	 * Assert.assertEquals(String.valueOf(380.8),statisticServiceImpl.getRevenue
	 * (from, to)); }
	 */

}
