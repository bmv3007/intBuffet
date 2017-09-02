package com.js.intbuffetproject.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.OrderDAO;
import com.js.intbuffetproject.dto.Cart;
import com.js.intbuffetproject.dto.OrderDTO;
import com.js.intbuffetproject.dto.OrdersProductsDTO;
import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.OrdersProducts;
import com.js.intbuffetproject.service.OrderService;
import com.js.intbuffetproject.util.ConverterProductDTO;

/**
 * Class OrderServiceImpl contains business logic related to class Order.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private static final Logger LOG = Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private ConverterProductDTO converterProductDTO;

	@Override
	@Transactional
	public boolean addOrder(Order order) {
	
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
			for(OrdersProducts ordersProduct: cart.getOrders_products()){
				Item item= new Item(ordersProduct.getProduct(), ordersProduct.getQuantity());
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

	@Override
	public OrderDTO copyOrder(Long id) {

    Order oldOrder = orderDAO.getOrderById(id);
    OrderDTO newOrder = new OrderDTO();
    List<OrdersProductsDTO> newListOrdersProducts = new ArrayList<OrdersProductsDTO>();
    if(oldOrder.getOrders_products()!=null){
    for(OrdersProducts oldOrdersProducts:oldOrder.getOrders_products()){
    	OrdersProductsDTO newOrdersProducts = new OrdersProductsDTO();
    	ProductDTO productDTO = converterProductDTO.convertToDTO(oldOrdersProducts.getProduct());
    	newOrdersProducts.setProduct(productDTO);
    	newOrdersProducts.setOrder(newOrder);
    	newOrdersProducts.setQuantity(oldOrdersProducts.getQuantity());
    	newListOrdersProducts.add(newOrdersProducts); 
    }
    }
   
    newOrder.setAddress(oldOrder.getAddress());
    newOrder.setDeliverymethod(oldOrder.getDeliverymethod());
    newOrder.setOrdersProductsDTO(newListOrdersProducts);
    newOrder.setOrdertotal(oldOrder.getOrdertotal());
    newOrder.setPaid(false);
    newOrder.setPaymentmethod(oldOrder.getPaymentmethod());
        
		return newOrder;
	}
	

}