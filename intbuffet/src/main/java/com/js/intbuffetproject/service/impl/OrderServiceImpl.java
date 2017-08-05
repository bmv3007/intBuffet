package com.js.intbuffetproject.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.OrderDAO;
import com.js.intbuffetproject.dao.impl.OrderDAOImpl;
import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public boolean addOrder(Order order) {
		logger.info("====addOrder=====");

		orderDAO.addOrder(order);
		return true;

	}

	@Override
	@Transactional
	public void updateOrder(Order order) {

		orderDAO.updateOrder(order);

	}

	@Override
	public List<Order> getOrderByUsername(String username) {
		
		return orderDAO.listOrderByClient(username);
	}

	@Override
	public void removeOrder(Long id) {

		orderDAO.removeOrder(id);

	}
	
	@Override
	public void removeCart(String username){

		orderDAO.removeCart(username);

	}

	@Override
	public List<Order> listOrder() {
		
		return orderDAO.listOrder();
	}

	@Override
	public List<Order> listOrderFromTo(Date from, Date to) {
		
		return orderDAO.listOrderFromTo(from, to);
	}

	@Override
	public List<Order> listOrderByClient(String username) {
	
		return orderDAO.listOrderByClient(username);
	}

	@Override
	public Cart getCartByUsername(String username) {
		
		Order cart =  orderDAO.getCartByUsername(username);
		Cart oldCart = new Cart();
		
		if(cart != null){
			
			oldCart.setUser(cart.getUser());
			oldCart.setId(cart.getId());
			for(Product product: cart.getProducts()){
				Item item= new Item(product);
				oldCart.addProduct(item.getId(), item);
			}
			
			oldCart.setTotal(oldCart.getTotal());
		
		}
		
		return oldCart;
	}

	@Override
	public Order getOrderById(Long id) {

		return orderDAO.getOrderById(id);
		
	}

}