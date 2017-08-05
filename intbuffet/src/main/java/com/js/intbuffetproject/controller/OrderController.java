package com.js.intbuffetproject.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.AddressService;
import com.js.intbuffetproject.service.OrderService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.UserService;
import com.js.intbuffetproject.util.Util.Deliverymethod;
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

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView order() {
		ModelAndView modelAndView = new ModelAndView();

		if (httpSession.getAttribute("userDTO") != null) {
			if (httpSession.getAttribute("cart") != null) {

				Order order = new Order();
				order.setDate(new Date());
				Cart cart = (Cart) httpSession.getAttribute("cart");
				Collection<Item> listItems = cart.getProductsInCart().values();
				for(Item item: listItems){
					if(item.getQuantity()<1){
						cart.deleteProduct(item.getId());
						cart.setTotal(cart.getTotal());
					}
				}
				order.setOrderstatus(Orderstatus.PENDING_PAYMENT.getName());
				modelAndView.addObject("paymentmethod1", Arrays.asList(Paymentmethod.values()));
				modelAndView.addObject("deliverymethod", Arrays.asList(Deliverymethod.values()));
				modelAndView.addObject("countries", addressService.listCountries());
				modelAndView.addObject("cities", addressService.listCities());
				modelAndView.addObject("streets", addressService.listStreets());
				modelAndView.addObject("productLisInCart",	listItems);

			//	logger.info("order = index" + ((Cart) httpSession.getAttribute("cart")).getProductsInCart().values());
				modelAndView.setViewName("order");
				Address address = new Address();
				order.setAddress(address);
				modelAndView.addObject(order);

			}
		} else {
			logger.info("order = login");
			modelAndView.setViewName("login");

		}
		return modelAndView;

	}

	@RequestMapping(value = "/makeOrder", method = RequestMethod.POST)
	public String makeOrder(@ModelAttribute("order") Order order, BindingResult result) {
		UserDTO usetDTO = (UserDTO) httpSession.getAttribute("userDTO");
		User user = userService.getUserByUsername(usetDTO.getUsername());
		order.setUser(user);
		order.setDate(new Date());
		Cart cart = (Cart) httpSession.getAttribute("cart");
		List<Product> products = productService.fillProducts(cart.getProductsInCart().values());
		order.setProducts(products);
		order.setOrderstatus(Orderstatus.PENDING_PAYMENT.getName());
		order.setOrdertotal(cart.getTotal());
		logger.info("order date= " + order.getAddress());
		// logger.info("order total = " + order.getOrdertotal());

		ModelAndView modAndView = new ModelAndView();
		Address address = order.getAddress();
		Serializable id = addressService.addAddress(address);
		order.setAddress((Address) addressService.getAddressByID((Long) id));
		logger.info("order getCountry= " + order.getAddress().getCountry());
		logger.info("order " + order);
		orderService.addOrder(order);
		modAndView.setViewName("index");
		//orderService.removeCart(usetDTO.getUsername());
		cart = new Cart();
		httpSession.setAttribute("cart", cart);
		return "redirect:/index";

	}

	@RequestMapping(value = "/getusersorders", method = RequestMethod.GET)
	public ModelAndView getUsersOrders(Locale locale) {
		ModelAndView modelAndView = new ModelAndView();
		if (((UserDTO) httpSession.getAttribute("userDTO")) == null) {
			modelAndView.setViewName("index");
			return modelAndView;
		}else{

		UserDTO user = (UserDTO) httpSession.getAttribute("userDTO");
		logger.info("Orders = " + orderService.getOrderByUsername(user.getUsername()).toArray());
		List<Order> listOrder = orderService.listOrderByClient(user.getUsername());
		modelAndView.addObject("orderstatus", Arrays.asList(Orderstatus.values()));
		modelAndView.addObject("UsersOrders", listOrder);
		modelAndView.setViewName("listOrders");

		return modelAndView;
		}

	}

	@RequestMapping(value = "/getallusersorders", method = RequestMethod.GET)
	public ModelAndView getAllUsersOrders(Locale locale) {
		ModelAndView modelAndView = new ModelAndView();
		if (((UserDTO) httpSession.getAttribute("userDTO")) == null) {
			modelAndView.setViewName("index");
			return modelAndView;
		}

		modelAndView.addObject("orderstatus", Arrays.asList(Orderstatus.values()));

		List<Order> listOrder = orderService.listOrder();
		modelAndView.addObject("UsersOrders", listOrder);
		modelAndView.setViewName("listOrders");

		return modelAndView;

	}

	@RequestMapping(value = "/updateOrder", params = { "id", "status" }, method = RequestMethod.GET)
	public String updateOrder(@RequestParam("id") Long id, @RequestParam("status") String status) {
		logger.info(" updateOrder Order id = " + id);
		logger.info(" updateOrder Order status = " + status);
		Order order = orderService.getOrderById(id);
		order.setOrderstatus(status);
          
		logger.info(" updateOrder getOrderstatus = " + order.getOrderstatus());
		orderService.updateOrder(order);
		
		return "redirect:/getallusersorders";

	}

	// (value = "/save_cart", method = RequestMethod.GET)

}
