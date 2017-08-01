package com.js.intbuffetproject.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.User;
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

	
	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index2() {
		// logger.info(accessDecisionManager);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> list = authentication.getAuthorities();
		UserDTO usD= new UserDTO();
		usD.setAuthorities(list);
		usD.setUsername(authentication.getName());
		logger.info("GrantedAuthority = "+list);
		logger.info("authentication.getDetails() = "+authentication.getDetails());
		logger.info("authentication.getCredentials = "+authentication.getCredentials());
		httpSession.setAttribute("userDTO", usD);
		return "index2";
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
		logger.info("getBirthday = " + user.getBirthday());
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

}
