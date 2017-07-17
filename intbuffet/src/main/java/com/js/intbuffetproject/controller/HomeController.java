package com.js.intbuffetproject.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping("/index")
	@ResponseBody
	public ModelAndView listProducts(Map<String, Object> map, Locale locale, HttpSession session) {
		ModelAndView modAndView = new ModelAndView();
		// logger.info("local = " + locale);
		map.put("productList1", productService.listProduct());
		session.setAttribute("currentProductList", productService.listProduct());
		session.setAttribute("username", "");
		session.setAttribute("search", "");
		modAndView.addAllObjects(map);
		modAndView.setViewName("index");

		return modAndView;
	}

	@RequestMapping("/")
	public String home(Locale local) {

		return "redirect:/index";
	}

	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Long itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

		response.getOutputStream().write(productService.getProductByID(itemId).getImage());

		response.getOutputStream().close();

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goin() {
		// logger.info(accessDecisionManager);

		return "login";
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel() {

		return "redirect:/index";
	}

	@RequestMapping("/search")
	@ResponseBody
	public ModelAndView seachProducts(@RequestParam("search") String searchtext, Map<String, Object> map, Locale locale,
			HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		ModelAndView modAndView = new ModelAndView();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// logger.info("local = " + locale);
		session.setAttribute("search", searchtext);
		map.put("contact", new Product());
		map.put("productList1", productService.searchProduct(searchtext));
		map.put("seachtext", "seachtext");
		modAndView.addAllObjects(map);
		modAndView.setViewName("index");

		return modAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody // @ResponseBody - нужен, когда мы НЕ перенаправляем на
	// другую страницу, а пишем ответ на той же странице
	String checkStrength(@RequestParam Long idgood, HttpSession session) {
		logger.info("idgood = " + idgood);
		Product product = productService.getProductByID(idgood);
		logger.info("product = " + product.getName());
		if (session.getAttribute("cart") == null) {

			logger.info("cart is null");
			Cart cart = new Cart();
			cart.addProduct(product, 1);
			session.setAttribute("cart", cart);
			logger.info("cart =" + cart.getProductsInCart().elements());
		} else if (((Cart) session.getAttribute("cart")).getProductsInCart().containsKey(product)) {
			Cart cart = (Cart) session.getAttribute("cart");
			cart.addProduct(product, cart.getProductsInCart().get(product) + 1);
			session.setAttribute("cart", cart);
		} else {

			Cart cart = (Cart) session.getAttribute("cart");
			cart.addProduct(product, 1);
			session.setAttribute("cart", cart);
		}
		
		return "OK";

	}

	@RequestMapping("/cart")
	@ResponseBody
	public ModelAndView cart(Map<String, Object> map, Locale locale, HttpSession session) {
		ModelAndView modAndView = new ModelAndView();
		logger.info("session.getAttribute(cart) = " + session.getAttribute("cart"));
		if (session.getAttribute("cart") != null) {
			map.put("productLisInCart", ((Cart) session.getAttribute("cart")).getProductsInCart().keys());

			modAndView.addAllObjects(map);
		}
		modAndView.setViewName("cart");

		return modAndView;

	}

}
