package com.js.intbuffetproject.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.util.SearchParameter;

/**
* Handles requests for searching products: /find,  /search.
* 
* @author Maria Borovtsova
* 
* @version 1.1
*/
@Controller
public class SearchController {

	private static final Logger LOG = Logger.getLogger(SearchController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Product> find(@RequestParam("categoryId") Long categoryId,
			@RequestParam("vegetarian") boolean vegetarian) {

		return productService.searchProductByParameters(categoryId, vegetarian);
	}

	@RequestMapping("/search")
	@ResponseBody
	public ModelAndView seachProducts(@RequestParam("search") String searchtext, Map<String, Object> map, Locale locale,
			HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		ModelAndView modAndView = new ModelAndView();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {

			LOG.info(e.getMessage());
		}

		session.setAttribute("search", searchtext);
		map.put("productList1", productService.searchProduct(searchtext));
		map.put("seachtext", "seachtext");
		modAndView.addAllObjects(map);
		modAndView.setViewName("index");

		return modAndView;
	}

}
