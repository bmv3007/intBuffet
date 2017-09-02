package com.js.intbuffetproject.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.js.intbuffetproject.service.ProductService;

/**
* Handles requests "/getImage" and "/getBigImage" to get images.
* 
* @author Maria Borovtsova
* 
* @version 1.1
*/
@Controller
public class ImageController {

	private static final Logger LOG = Logger.getLogger(ImageController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Long itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		String imageName = productService.getProductByID(itemId).getImage();
		File file = new File("C:\\intbuffet\\images\\" + imageName);

		LOG.info("itemId, imageName, file =  " + itemId + " - " + imageName + " - " + file);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

		Files.copy(file.toPath(), response.getOutputStream());

	}
	
	@RequestMapping(value = "/getBigImage", method = RequestMethod.GET)
	public void showBigImage(@RequestParam("id") Long itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		String imageName = productService.getProductByID(itemId).getImage();
		File file = new File("C:\\intbuffet\\images\\big_" + imageName);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

		Files.copy(file.toPath(), response.getOutputStream());

	}

}
