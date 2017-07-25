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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("UserWithoutPasswordDTO")
public class HomeController {

	@Autowired
	private HttpSession httpSession;

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	@ResponseBody
	public ModelAndView listProducts(Map<String, Object> map, Locale locale) {
		ModelAndView modAndView = new ModelAndView();
		// logger.info("local = " + locale);
		map.put("productList1", productService.listProduct());
		httpSession.setAttribute("currentProductList", productService.listProduct());
		httpSession.setAttribute("categoriesList", categoryService.listCategories());
		httpSession.setAttribute("username", "");
		httpSession.setAttribute("search", "");
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		// logger.info(accessDecisionManager);
		status.setComplete();
		return "index";
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
	void checkStrength(@RequestParam Long idgood) {
		logger.info("idgood = " + idgood);
		Product product = productService.getProductByID(idgood);
		logger.info("product = " + product.getName());
		if (httpSession.getAttribute("cart") == null) {

			logger.info("cart is null");
			Cart cart = new Cart();
			cart.addProduct(product, 1);
			httpSession.setAttribute("cart", cart);
			logger.info("cart =" + cart.getProductsInCart().elements());
		} else if (((Cart) httpSession.getAttribute("cart")).getProductsInCart().containsKey(product)) {
			Cart cart = (Cart) httpSession.getAttribute("cart");
			cart.addProduct(product, cart.getProductsInCart().get(product) + 1);
			httpSession.setAttribute("cart", cart);
		} else {

			Cart cart = (Cart) httpSession.getAttribute("cart");
			cart.addProduct(product, 1);
			httpSession.setAttribute("cart", cart);
		}
	}

	@RequestMapping("/cart")
	@ResponseBody
	public ModelAndView cart(Map<String, Object> map, Locale locale) {
		ModelAndView modAndView = new ModelAndView();
		logger.info("session.getAttribute(cart) = " + httpSession.getAttribute("cart"));
		if (httpSession.getAttribute("cart") != null) {
			map.put("productLisInCart", ((Cart) httpSession.getAttribute("cart")).getProductsInCart().keys());

			modAndView.addAllObjects(map);
		}
		modAndView.setViewName("cart");

		return modAndView;

	}

}