package com.js.intbuffetproject.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.js.intbuffetproject.service.StatisticService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StatisticController {

	@Autowired
	private HttpSession httpSession;

	private static final Logger logger = Logger.getLogger(StatisticController.class);

	@Autowired
	private StatisticService statisticService;

	@RequestMapping(value = "/get_statistic", method = RequestMethod.GET)
	public ModelAndView get_statistic() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("statistic");
		modelAndView.addObject("topClients", statisticService.getTopClients());
		modelAndView.addObject("topProducts", statisticService.getTopProducts());
		return modelAndView;
	}
	
	@RequestMapping(value = "/get_revenue",  method = RequestMethod.GET)
	@ResponseBody
	public double get_revenue(@RequestParam("from") Date from, @RequestParam("to") Date to) {
		
		return statisticService.getRevenue(from, to);
	}

}
