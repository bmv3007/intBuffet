package com.js.intbuffetproject.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
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

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("userDTO")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;


	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index2() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> list = authentication.getAuthorities();
		UserDTO usD = new UserDTO();
		usD.setAuthorities(list);
		usD.setUsername(authentication.getName());
		httpSession.setAttribute("userDTO", usD);
		logger.info("usD.getUsername() = "+usD.getUsername());
		Cart cart = orderService.getCartByUsername(usD.getUsername());
		logger.info("old cart = "+cart);
				
			httpSession.setAttribute("cart", cart);
	
		return "redirect:/index";
	}

	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String goin1() {
		// logger.info(accessDecisionManager);

		return "login";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		// logger.info(accessDecisionManager);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.addObject("address", new Address());
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel() {

		return "redirect:/index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("user") User user, BindingResult result,
			@RequestParam("birthday") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		user.setBirthday(date);
		logger.info("getUsername = " + user.getUsername());

		ModelAndView modAndView = new ModelAndView();

		if (userService.addUser(user)) {
			modAndView.setViewName("index");
			return modAndView;
		} else {
			modAndView.addObject("errormassage", "The user with login \"" + user.getUsername() + "\" already exists!");
			modAndView.setViewName("registration");
			return modAndView;
		}

	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public User getUser(String username) {
		// logger.info(accessDecisionManager);

		return userService.getUserByUsername(username);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile() {
		// logger.info(accessDecisionManager);
		ModelAndView modelAndView = new ModelAndView();
		String usName = ((UserDTO) httpSession.getAttribute("userDTO")).getUsername();
		logger.info("httpSession.getAttribute('userDTO')) = "
				+ ((UserDTO) httpSession.getAttribute("userDTO")).getUsername());
		User user = userService.getUserByUsername(usName);
		logger.info("profile" + user);
		modelAndView.addObject("user", user);
		modelAndView.addObject("countries", addressService.listCountries());
		modelAndView.addObject("cities", addressService.listCities());
		modelAndView.addObject("streets", addressService.listStreets());
		modelAndView.setViewName("profile");
		return modelAndView;
	}

	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public ModelAndView makeOrder(@ModelAttribute("user") User user, BindingResult result) {
		Serializable idAddress = addressService.addAddress(user.getAddress());

		ModelAndView modelAndView = new ModelAndView();
		userService.updateUser(user);
		modelAndView.addObject("user", user);
		modelAndView.addObject("countries", addressService.listCountries());
		modelAndView.addObject("cities", addressService.listCities());
		modelAndView.addObject("streets", addressService.listStreets());
		modelAndView.setViewName("profile");

		return modelAndView;

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		// logger.info(accessDecisionManager);
		
		Cart cart = (Cart) httpSession.getAttribute("cart");
		if(cart!= null){
			if (((UserDTO) httpSession.getAttribute("userDTO")) != null) {
				
				UserDTO usetDTO = (UserDTO) httpSession.getAttribute("userDTO");
				User user = userService.getUserByUsername(usetDTO.getUsername());
				orderService.removeCart(usetDTO.getUsername());
				Order order = new Order();
				order.setCart(true);
				order.setUser(user);
				order.setDate(new Date());
				logger.info("order.isCart()"+order.isCart());
				List<Product> products = productService
						.fillProducts(cart.getProductsInCart().values());
				order.setProducts(products);
				order.setOrdertotal(cart.getTotal());
				orderService.addOrder(order);
				cart = new Cart();
				httpSession.setAttribute("cart", cart);
			}
		}
		//*****************************************************************		
		status.setComplete();
		return "redirect:/logout1";
	}

}
