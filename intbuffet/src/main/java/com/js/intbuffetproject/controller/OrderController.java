package com.js.intbuffetproject.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.AddressService;
import com.js.intbuffetproject.service.OrderService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.UserService;
import com.js.intbuffetproject.util.Util;
import com.js.intbuffetproject.util.Util.Orderstatus;
import com.js.intbuffetproject.util.Util.Paymentmethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OrderController {

	private static final Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/makeOrder", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("order") Order order, BindingResult result) {
		UserDTO usetDTO = (UserDTO) httpSession.getAttribute("userDTO");
		User user = userService.getUserByUsername(usetDTO.getUsername());
		order.setUser(user);
		order.setDate(new Date());
		List<Product> products = productService
				.fillProducts(((Cart) httpSession.getAttribute("cart")).getProductsInCart().values());
		order.setProducts(products);
		order.setOrderstatus(Orderstatus.PENDING_PAYMENT.getName());
		// logger.info("order = " + order.getUser());
		logger.info("order date = " + order.getDate());
		Serializable idAddress = addressService.addAddress(order.getAddress());

		ModelAndView modAndView = new ModelAndView();
		orderService.addOrder(order);
		modAndView.setViewName("index");
		Cart cart = new Cart();
		httpSession.setAttribute("cart", cart);
		return modAndView;

	}
	
	@RequestMapping("/getUsersOrders")
	public ModelAndView getUsersOrders(Locale locale) {
		ModelAndView modAndView = new ModelAndView();
		logger.info("((UserDTO) httpSession.getAttribute('user')).getUsername())="+ ((UserDTO) httpSession.getAttribute("user")).getUsername());
		UserDTO user= (UserDTO) httpSession.getAttribute("user");
		modAndView.addObject("UsersOrders", orderService.getOrderByUsername(user.getUsername())); 
		
		modAndView.setViewName("listOrders");

		return modAndView;

	}

}
