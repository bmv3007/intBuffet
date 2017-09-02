package com.js.intbuffetproject.controller;

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

import com.js.intbuffetproject.dto.Cart;
import com.js.intbuffetproject.service.CartService;
import com.js.intbuffetproject.service.ProductService;

/**
 * Handles requests for cart: /add_to_cart, /delete_from_cart, /cart,
 * /delete_item/{id}.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Controller
public class CartController {

	@Autowired
	private HttpSession httpSession;

	private static final Logger LOG = Logger.getLogger(CartController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	/**
	 * Add product to cart
	 * 
	 * @param idgood	Product's id
	 * @return 	ArrayList with quantity of current product, total quantity of
	 *         products and total sum
	 */
	@RequestMapping(value = "/add_to_cart", method = RequestMethod.POST)
	public @ResponseBody ArrayList addItem(@RequestParam Long idgood) {

		Cart cart = (Cart) httpSession.getAttribute("cart");
		int quantity = 0;
		if (httpSession.getAttribute("cart") == null) {

			cart = cartService.creatNewCart(idgood);
			httpSession.setAttribute("cart", cart);

		}

		else {
			cart = cartService.addToCart((Cart) httpSession.getAttribute("cart"), idgood);
			httpSession.setAttribute("cart", cart);
		}
		quantity = cart.getProductsInCart().get(idgood).getQuantity();
		ArrayList data = new ArrayList();
		data.add(cart.getTotal());
		data.add(quantity);
		data.add(cart.getTotalItems());

		return data;

	}

	/**
	 * Delete current product from cart
	 * 
	 * @param idgood - product's id
	 * @return ArrayList with total quantity of products and total sum
	 */
	@RequestMapping(value = "/delete_from_cart", method = RequestMethod.POST)
	public @ResponseBody ArrayList deleteItem(@RequestParam Long idgood) {

		Cart cart = (Cart) httpSession.getAttribute("cart");

		int quantity = 0;

		if (cart == null) {
			return null;
		} else {
			httpSession.setAttribute("cart", cartService.removeFromCart(cart, idgood));
		}

		quantity = cart.getProductsInCart().get(idgood).getQuantity();

		ArrayList data = new ArrayList();
		data.add(cart.getTotal());
		data.add(quantity);

		return data;

	}

	@RequestMapping("/cart")
	@ResponseBody
	public ModelAndView cart(Map<String, Object> map, Locale locale) {
		ModelAndView modAndView = new ModelAndView();

		if (httpSession.getAttribute("cart") != null) {
			map.put("productLisInCart", ((Cart) httpSession.getAttribute("cart")).getProductsInCart().values());

			modAndView.addAllObjects(map);
		}
		modAndView.setViewName("cart");

		return modAndView;

	}

	/**
	 * Delete one item of current product from cart
	 * 
	 * @param idgood - product's id
	 * 
	 */
	@RequestMapping(value = "/delete_item/{id}", method = RequestMethod.GET)
	public String deleteItemfromCart(@PathVariable("id") Long idgood) {

		Cart cart = (Cart) httpSession.getAttribute("cart");
		if (cart != null) {

			httpSession.setAttribute("cart", cartService.removeItemFromCart(cart, idgood));
		}

		return "redirect:/cart";

	}

}
