package com.js.intbuffetproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Product;

import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.util.FileHolder;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {

	private static String UPLOAD_LOCATION = "C:\\intbuffet\\images\\";

	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/addnewproduct", method = RequestMethod.GET)
	public ModelAndView addNewProduct(ModelMap model) {

		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		modelAndView.setViewName("product");
		modelAndView.addObject("categories", categoryService.listCategories());
		modelAndView.addObject(product);
		FileHolder fileHolder = new FileHolder();
		model.addAttribute("fileHolder", fileHolder);
		modelAndView.addObject(model);
		return modelAndView;
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute("product") Product product, BindingResult result,
			@ModelAttribute("category") Category category) {

		productService.addProduct(product);

		return "redirect:/addnewproduct";

	}

	
	@RequestMapping(value = "/uploadFile1", method = RequestMethod.POST)
	public @ResponseBody String singleFileUpload(HttpServletRequest request) throws IOException {
		logger.info(request.getAttributeNames());
		logger.info(request.getParameterNames());
		logger.info(request);
		//MultipartFile multipartFile = fileHolder.getFile();

		// Now do something with file...
		//*File serverFile = new File(UPLOAD_LOCATION + fileHolder.getOriginalFilename());
		//*BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		//*stream.write(fileHolder.getBytes());
		//*stream.close();
		// Files.copy(fileHolder.getFile().getBytes(),
		// response.getOutputStream(new File(UPLOAD_LOCATION +
		// fileHolder.getFile().getOriginalFilename())));

		//*String fileName = fileHolder.getOriginalFilename();
		
		return "success";
	}
	
	
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
		
        if (!file.isEmpty()) {
        	File serverFile = new File(UPLOAD_LOCATION + file.getOriginalFilename());
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                return "The File is uploaded";
            } catch (Exception e) {
                return "The File hasn't uploaded because " + e.getMessage();
            }
        } else {
            return "The File is empty!";
        }
    }
}
