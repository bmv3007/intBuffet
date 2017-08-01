package com.js.intbuffetproject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Form_Order_Address;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.AddressService;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.UserService;
import com.js.intbuffetproject.util.Util.Paymentmethod;
import com.js.intbuffetproject.util.Util.Deliverymethod;
import com.js.intbuffetproject.util.Util.Orderstatus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CartController {

	@Autowired
	private HttpSession httpSession;

	private static final Logger logger = Logger.getLogger(CartController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody // @ResponseBody - нужен, когда мы НЕ перенаправляем на
	// другую страницу, а пишем ответ на той же странице
	void addItem(@RequestParam Long idgood) {
		logger.info("idgood = " + idgood);
		Product product = productService.getProductByID(idgood);
		logger.info("product = " + product.getName());
		Cart cart = null;
		Item item = null;
		if (httpSession.getAttribute("cart") == null) {

			logger.info("cart is null");
			cart = new Cart();
			item = new Item(idgood, product.getName(), product.getDescription(), product.getPrice(), 1);
			cart.addProduct(idgood, item);
			httpSession.setAttribute("cart", cart);
			logger.info("cart =" + cart.getProductsInCart().values());
		} else if (((Cart) httpSession.getAttribute("cart")).getProductsInCart().containsKey(idgood)) {
			cart = (Cart) httpSession.getAttribute("cart");
			item = cart.getProductsInCart().get(idgood);
			Integer quantity = (Integer) cart.getProductsInCart().get(idgood).getQuantity() + 1;
			item.setQuantity(quantity);

			cart.addProduct(idgood, item);
			httpSession.setAttribute("cart", cart);
			logger.info("cart has it");
		} else {

			cart = (Cart) httpSession.getAttribute("cart");
			item = new Item(idgood, product.getName(), product.getDescription(), product.getPrice(), 1);
			cart.addProduct(idgood, item);
			httpSession.setAttribute("cart", cart);
			logger.info("cart has smth");
		}
	}

	@RequestMapping("/cart")
	@ResponseBody
	public ModelAndView cart(Map<String, Object> map, Locale locale) {
		ModelAndView modAndView = new ModelAndView();
		logger.info("session.getAttribute(cart) = " + httpSession.getAttribute("cart"));
		if (httpSession.getAttribute("cart") != null) {
			map.put("productLisInCart", ((Cart) httpSession.getAttribute("cart")).getProductsInCart().values());

			modAndView.addAllObjects(map);
		}
		modAndView.setViewName("cart");

		return modAndView;

	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView order() {
		ModelAndView modelAndView = new ModelAndView();
		logger.info("userDTO = " + httpSession.getAttribute("userDTO"));

		if (httpSession.getAttribute("userDTO") != null) {
			if (httpSession.getAttribute("cart") != null) {
				// Product product = productService.getProductByID(idgood);

				Order order = new Order();
				order.setDate(new Date());

				List<Product> products = productService
						.fillProducts(((Cart) httpSession.getAttribute("cart")).getProductsInCart().values());
				order.setProducts(products);
				order.setOrderstatus(Orderstatus.PENDING_PAYMENT.getName());
				modelAndView.addObject("paymentmethod1", Arrays.asList(Paymentmethod.values()));
				modelAndView.addObject("deliverymethod", Arrays.asList(Deliverymethod.values()));
				modelAndView.addObject("countries", addressService.listCountries());
				modelAndView.addObject("cities", addressService.listCities());
				modelAndView.addObject("streets", addressService.listStreets());

				logger.info("order = index");
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

}
