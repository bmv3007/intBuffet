package com.js.intbuffetproject.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;


/**
 * Handles requests for the application home page.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */

@Controller
public class HomeController {

	@Autowired
	private HttpSession httpSession;

	private static final Logger LOG = Logger.getLogger(HomeController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	
	/**
	 * Handles request "/index"
	 * @return ModelAndView with View index.
	 */
	@RequestMapping("/index")
	@ResponseBody
	public ModelAndView listProducts(Map<String, Object> map, Locale locale) {
		ModelAndView modAndView = new ModelAndView();
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

	/*@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Long itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

		response.getOutputStream().close();

	}*/

}
