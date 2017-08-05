package com.js.intbuffetproject.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.AddressService;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.UserService;

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

	@RequestMapping(value = "/add_to_cart", method = RequestMethod.GET)
	public @ResponseBody // @ResponseBody - нужен, когда мы НЕ перенаправляем на
	// другую страницу, а пишем ответ на той же странице
	ArrayList addItem(@RequestParam Long idgood) {
		logger.info("idgood = " + idgood);
		Product product = productService.getProductByID(idgood);
		logger.info("product = " + product.getName());
		Cart cart = null;
		Item item = null;
		Integer quantity = 0;
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
			quantity = (Integer) cart.getProductsInCart().get(idgood).getQuantity() + 1;
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
		ArrayList data = new ArrayList();
		data.add(cart.getTotal());
		data.add(quantity);
		data.add(cart.getTotalItems());

		return data;

	}

	@RequestMapping(value = "/delete_from_cart", method = RequestMethod.GET)
	public @ResponseBody // @ResponseBody - нужен, когда мы НЕ перенаправляем на
	// другую страницу, а пишем ответ на той же странице
	ArrayList deleteItem(@RequestParam Long idgood) {
		logger.info("idgood = " + idgood);
		Product product = productService.getProductByID(idgood);
		logger.info("product = " + product.getName());
		Cart cart = null;
		Item item = null;
		Integer quantity = 0;
		if (httpSession.getAttribute("cart") == null) {

			logger.info("cart is null");

			return null;

		} else if (((Cart) httpSession.getAttribute("cart")).getProductsInCart().containsKey(idgood)) {
			cart = (Cart) httpSession.getAttribute("cart");
			item = cart.getProductsInCart().get(idgood);
			quantity = (Integer) cart.getProductsInCart().get(idgood).getQuantity();
			if (quantity > 0) {
				--quantity;
				item.setQuantity(quantity);
			}
			/*
			 * if (quantity == 0) {
			 * 
			 * cart.getProductsInCart().remove(item);
			 * 
			 * }
			 */

			httpSession.setAttribute("cart", cart);
			logger.info("cart has it");
		} else {
			logger.info("cart doesn't have it");
		}
		ArrayList data = new ArrayList();
		data.add(cart.getTotal());
		data.add(quantity);

		return data;

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

	@RequestMapping(value = "/delete_item/{id}", method = RequestMethod.GET)
	public String deleteItemfromCart(@PathVariable("id") Long idgood) {
		logger.info("idgood = " + idgood);

		Cart cart = null;

		if (httpSession.getAttribute("cart") != null && ((Cart) httpSession.getAttribute("cart")).getProductsInCart().containsKey(idgood)) {
			cart = (Cart) httpSession.getAttribute("cart");
			cart.getProductsInCart().remove(idgood);
			cart.setTotal(cart.getTotal());
			httpSession.setAttribute("cart", cart);
			logger.info("cart has it");
		}

		return "redirect:/cart";

	}

}
