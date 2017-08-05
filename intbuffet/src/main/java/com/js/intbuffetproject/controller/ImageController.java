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
 * Handles requests for the application home page.
 */
@Controller
public class ImageController {

	private static final Logger logger = Logger.getLogger(ImageController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Long itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		String imageName = productService.getProductByID(itemId).getImage();
		File file = new File("C:\\intbuffet\\images\\" + imageName);

		logger.info("itemId, imageName, file =  " + itemId + " - " + imageName + " - " + file);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

		Files.copy(file.toPath(), response.getOutputStream());

	}

}
