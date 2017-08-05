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

import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.ProductService;


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

	@RequestMapping(value = "/add_to_cart", method = RequestMethod.GET)
	public @ResponseBody ArrayList addItem(@RequestParam Long idgood) {

		Product product = productService.getProductByID(idgood);

		Cart cart = null;
		Item item = null;
		Integer quantity = 0;
		if (httpSession.getAttribute("cart") == null) {

			cart = new Cart();
			item = new Item(idgood, product.getName(), product.getDescription(), product.getPrice(), 1);
			cart.addProduct(idgood, item);
			httpSession.setAttribute("cart", cart);

		} else if (((Cart) httpSession.getAttribute("cart")).getProductsInCart().containsKey(idgood)) {
			cart = (Cart) httpSession.getAttribute("cart");
			item = cart.getProductsInCart().get(idgood);
			quantity = (Integer) cart.getProductsInCart().get(idgood).getQuantity() + 1;
			item.setQuantity(quantity);

			cart.addProduct(idgood, item);
			httpSession.setAttribute("cart", cart);

		} else {

			cart = (Cart) httpSession.getAttribute("cart");
			item = new Item(idgood, product.getName(), product.getDescription(), product.getPrice(), 1);
			cart.addProduct(idgood, item);
			httpSession.setAttribute("cart", cart);

		}
		ArrayList data = new ArrayList();
		data.add(cart.getTotal());
		data.add(quantity);
		data.add(cart.getTotalItems());

		return data;

	}

	@RequestMapping(value = "/delete_from_cart", method = RequestMethod.GET)
	public @ResponseBody ArrayList deleteItem(@RequestParam Long idgood) {

		Cart cart = null;
		Item item = null;
		Integer quantity = 0;
		if (httpSession.getAttribute("cart") == null) {

			return null;

		} else if (((Cart) httpSession.getAttribute("cart")).getProductsInCart().containsKey(idgood)) {
			cart = (Cart) httpSession.getAttribute("cart");
			item = cart.getProductsInCart().get(idgood);
			quantity = (Integer) cart.getProductsInCart().get(idgood).getQuantity();
			if (quantity > 0) {
				--quantity;
				item.setQuantity(quantity);
			}

			httpSession.setAttribute("cart", cart);

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

		if (httpSession.getAttribute("cart") != null) {
			map.put("productLisInCart", ((Cart) httpSession.getAttribute("cart")).getProductsInCart().values());

			modAndView.addAllObjects(map);
		}
		modAndView.setViewName("cart");

		return modAndView;

	}

	@RequestMapping(value = "/delete_item/{id}", method = RequestMethod.GET)
	public String deleteItemfromCart(@PathVariable("id") Long idgood) {
		
		Cart cart = null;

		if (httpSession.getAttribute("cart") != null
				&& ((Cart) httpSession.getAttribute("cart")).getProductsInCart().containsKey(idgood)) {
			cart = (Cart) httpSession.getAttribute("cart");
			cart.getProductsInCart().remove(idgood);
			cart.setTotal(cart.getTotal());
			httpSession.setAttribute("cart", cart);
			
		}

		return "redirect:/cart";

	}

}
