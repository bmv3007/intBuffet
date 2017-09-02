package com.js.intbuffetproject.controller;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.js.intbuffetproject.dto.Cart;
import com.js.intbuffetproject.dto.OrderDTO;
import com.js.intbuffetproject.dto.OrdersProductsDTO;
import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.OrdersProducts;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.AddressService;
import com.js.intbuffetproject.service.OrderService;
import com.js.intbuffetproject.service.OrdersProductsService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.UserService;
import com.js.intbuffetproject.util.ConverterOrderDTO;
import com.js.intbuffetproject.util.Util.Deliverymethod;
import com.js.intbuffetproject.util.Util.Orderstatus;
import com.js.intbuffetproject.util.Util.Paymentmethod;

/**
* Handles requests for orders: /order,  /makeOrder, /getusersorders, /getallusersorders, /updateOrder.
* 
* @author Maria Borovtsova
* 
* @version 1.1
*/
@Controller
public class OrderController {

	private static final Logger LOG = Logger.getLogger(OrderController.class);

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

	@Autowired
	private OrdersProductsService ordersProductsService;
	
	@Autowired
	ConverterOrderDTO converterOrderDTO;
	
	/**
	 * Get page with order
	 * @return ModelAndView with View order
	 */
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView order() {
		ModelAndView modelAndView = new ModelAndView();

		if (httpSession.getAttribute("userDTO") != null) {
			if (httpSession.getAttribute("cart") != null) {

				Order order = new Order();
				order.setDate(new Date());
				Cart cart = (Cart) httpSession.getAttribute("cart");
				Collection<Item> listItems = cart.getProductsInCart().values();
				for (Item item : listItems) {
					if (item.getQuantity() < 1) {
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
				modelAndView.addObject("productLisInCart", listItems);
				modelAndView.setViewName("order");
				Address address = new Address();
				order.setAddress(address);
				modelAndView.addObject(order);

			}
		} else {

			modelAndView.setViewName("login");

		}
		return modelAndView;

	}

	/**
	 * Save order
	 * @param order	The order to save 
	 */
	@RequestMapping(value = "/makeOrder", method = RequestMethod.POST)
	public String makeOrder(@ModelAttribute("order") Order order, BindingResult result) {
		UserDTO usetDTO = (UserDTO) httpSession.getAttribute("userDTO");
		User user = userService.getUserByUsername(usetDTO.getUsername());
		order.setUser(user);
		order.setDate(new Date());
		Cart cart = (Cart) httpSession.getAttribute("cart");
		order.setOrderstatus(Orderstatus.PENDING_PAYMENT.getName());
		order.setOrdertotal(cart.getTotal());

		ModelAndView modAndView = new ModelAndView();
		Address address = order.getAddress();
		Serializable id = addressService.addAddress(address);
		order.setAddress((Address) addressService.getAddressByID((Long) id));
		orderService.addOrder(order);
		List<OrdersProducts> orders_products = productService.fillProducts(cart.getProductsInCart().values());
		ordersProductsService.setOrder(orders_products, order);
		ordersProductsService.saveOrdersProductsAll(orders_products);
		modAndView.setViewName("index");
		orderService.removeCart(usetDTO.getUsername());
		cart = new Cart();
		httpSession.setAttribute("cart", cart);
		return "redirect:/index";

	}

	/**
	 * Get all orders for current user
	 * @return ModelAndView with View listOrders 
	 */
	@RequestMapping(value = "/getusersorders", method = RequestMethod.GET)
	public ModelAndView getUsersOrders() {
		ModelAndView modelAndView = new ModelAndView();
		if (((UserDTO) httpSession.getAttribute("userDTO")) == null) {
			modelAndView.setViewName("index");
			return modelAndView;
		} else {

			UserDTO user = (UserDTO) httpSession.getAttribute("userDTO");
			List<Order> listOrder = orderService.listOrderByClient(user.getUsername());
			modelAndView.addObject("orderstatus", Arrays.asList(Orderstatus.values()));
			modelAndView.addObject("UsersOrders", listOrder);
			modelAndView.setViewName("listOrders");

			return modelAndView;
		}

	}

	/**
	 * Get all orders
	 * @return ModelAndView with View listOrders 
	 */
	@RequestMapping(value = "/getallusersorders", method = RequestMethod.GET)
	public ModelAndView getAllUsersOrders() {
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

	/**
	 * Update current order
	 * @param id	The order's id  
	 * @param status	The order's status to update  
	 */
	@RequestMapping(value = "/updateOrder", params = { "id", "status" }, method = RequestMethod.GET)
	public String updateOrder(@RequestParam("id") Long id, @RequestParam("status") String status) {

		Order order = orderService.getOrderById(id);
		order.setOrderstatus(status);
		orderService.updateOrder(order);

		return "redirect:/getallusersorders";

	}

	@RequestMapping("/repeatOrder/{id}")
	public ModelAndView repeatOrder(@PathVariable("id") Long id ) {
		OrderDTO order = orderService.copyOrder(id);
		ModelAndView modelAndView = new ModelAndView();
		//LOG.info("copy Order ***********************"+order.getId());
		if (httpSession.getAttribute("userDTO") != null) {
			order.setDate(new Date());
			order.setOrderstatus(Orderstatus.PENDING_PAYMENT.getName());
			//modelAndView.addObject("productLisInOrder", order.getOrdersProductsDTO());
			
			/*Address address = new Address();
			order.setAddress(address);*/
			modelAndView.addObject("paymentmethod", Arrays.asList(Paymentmethod.values()));
			modelAndView.addObject("deliverymethod", Arrays.asList(Deliverymethod.values()));
			modelAndView.addObject("countries", addressService.listCountries());
			modelAndView.addObject("cities", addressService.listCities());
			modelAndView.addObject("streets", addressService.listStreets());
			
			modelAndView.addObject("order",order);
			modelAndView.setViewName("orderdto");
			

		} else {

			modelAndView.setViewName("login");

		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/repeatOrder/makeCopyOrder", method = RequestMethod.POST)
	public String makeCopyOrder(@ModelAttribute("order") OrderDTO order, @ModelAttribute("order.ordersProductsDTO") List<OrdersProductsDTO> ordersProductsDTO, BindingResult result) {
		UserDTO userDTO = (UserDTO) httpSession.getAttribute("userDTO");
		User user = userService.getUserByUsername(userDTO.getUsername());
		order.setUser(userDTO);
		order.setDate(new Date());
		//order.setOrdersProductsDTO(ordersProductsDTO);
		//Cart cart = (Cart) httpSession.getAttribute("cart");
		order.setOrderstatus(Orderstatus.PENDING_PAYMENT.getName());
		//order.setOrdertotal(cart.getTotal());

		ModelAndView modAndView = new ModelAndView();
		Address address = order.getAddress();
		Serializable id = addressService.addAddress(address);
		order.setAddress((Address) addressService.getAddressByID((Long) id));
		Order order1 = converterOrderDTO.convertFromDTO(order);
		order1.setUser(user);
		orderService.addOrder(order1);
		List<OrdersProducts> orders_products = order1.getOrders_products();
		LOG.info("orders_products**********"+ordersProductsDTO);
		ordersProductsService.setOrder(orders_products, order1);
		ordersProductsService.saveOrdersProductsAll(orders_products);
		modAndView.setViewName("index");
		
		return "redirect:/index";

	}

}
