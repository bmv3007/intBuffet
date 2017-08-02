package com.js.intbuffetproject.controller;

import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Category;
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
public class CategoryController {

	@Autowired
	private HttpSession httpSession;

	private static final Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/categorycontroll", method = RequestMethod.GET)
	public ModelAndView addNewCategory() {
		ModelAndView modelAndView = new ModelAndView();
		Category category = new Category();
		modelAndView.setViewName("category");
		modelAndView.addObject("categories", categoryService.listCategories());
		modelAndView.addObject(category);
		return modelAndView;
	}

	@RequestMapping(value = "/newcategory", method = RequestMethod.POST)
	public String newCategory(@ModelAttribute("category") Category category, BindingResult result) {

		categoryService.addCategory(category);

		return "redirect:/categorycontroll";

	}

	@RequestMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Long id) {

		categoryService.removeCategory(id);

		return "redirect:/categorycontroll";
	}

	@RequestMapping("/updateCategory/{id}/{name}")
	public String updateCategory(@PathVariable("id") Long id, @PathVariable("name") String name) {
		logger.info(" updateCategory name = "+name);
		Category category = categoryService.getCategoryByID(id);
		category.setName(name);
		categoryService.updateCategory(category);

		return "redirect:/categorycontroll";
	}

}
