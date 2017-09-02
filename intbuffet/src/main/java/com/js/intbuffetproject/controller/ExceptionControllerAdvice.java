package com.js.intbuffetproject.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
* Handles all not handled earlier exceptions.
* 
* @author Maria Borovtsova
* 
* @version 1.1
*/
@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {
		
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("message", e.getMessage());

		return modelAndView;
	}
}