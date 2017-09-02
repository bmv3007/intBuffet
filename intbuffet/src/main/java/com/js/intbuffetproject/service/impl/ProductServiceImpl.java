package com.js.intbuffetproject.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.js.intbuffetproject.dao.ProductDAO;
import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.exception.FileIsEmptyException;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.OrdersProducts;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.SendJMS;
import com.js.intbuffetproject.util.SearchParameter;

/**
 * Class ProductServiceImpl contains business logic related to class Product.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = Logger.getLogger(ProductServiceImpl.class);

	private static String UPLOAD_LOCATION = "C:\\intbuffet\\images\\";

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SendJMS sendJMS;

	@Transactional
	public void addProduct(Product product) throws FileIsEmptyException, IOException {
		boolean fileSaved = false;
		MultipartFile file = product.getFileHolder();
		if (file.isEmpty()) {
			throw new FileIsEmptyException("Select a file please!");
		}

		fileSaved = addImage(file);

		if (fileSaved) {

			// product.setCategory(categoryService.getCategoryByID(product.getCategory().getId()));
			product.setImage(file.getOriginalFilename());

			productDAO.addProduct(product);
		}

		try {

			sendJMS.sendJMS();

		} catch (Exception e) {

			LOG.error(e);

		}
	}

	@Transactional
	public boolean addImage(MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			File serverFile = new File(UPLOAD_LOCATION + file.getOriginalFilename());
			BufferedOutputStream stream = null;
			try {
				byte[] bytes = file.getBytes();
				stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
				return false;
			} finally {
				if (stream != null) {
					stream.close();
				}
			}
		} else {
			return false;
		}
		return true;

	}

	@Transactional
	public List<Product> listProduct() {

		return productDAO.listProduct();
	}

	@Transactional
	public void removeProduct(Long id) {
		productDAO.removeProduct(id);
	}

	@Override
	public Product getProductByID(Long id) {

		return productDAO.getProductByID(id);
	}

	@Override
	public List<Product> searchProduct(String searchtext) {

		return productDAO.searchProduct(searchtext);
	}

	@Transactional
	@Override
	public List<Product> searchProductByParameters(Long categoryId, boolean vegetarian) {
		SearchParameter searchParameter = new SearchParameter();
		searchParameter.setCategoryID(categoryId);
		searchParameter.setVegetarian(vegetarian);
		
		List<Product> listProduct = productDAO.searchProductByParameters(searchParameter);
		for (Product product : listProduct) {
			product.setImage(product.getImage());
			product.setOrders_products(null);
		}
		return listProduct;
	}

	@Override
	public List<OrdersProducts> fillProducts(Collection<Item> items) {

		List<OrdersProducts> ordersProducts = new ArrayList<>();
		for (Item item : items) {
			Product product = getProductByID(item.getId());
			int sellQuantity = product.getSell_quantity() + item.getQuantity();
			productDAO.updateSellQuantity(product, sellQuantity);
			OrdersProducts orderProduct = new OrdersProducts();
			orderProduct.setProduct(product);
			orderProduct.setQuantity(item.getQuantity());

			ordersProducts.add(orderProduct);
		}
		
		try {

			sendJMS.sendJMS();

		} catch (Exception e) {

			LOG.error(e);

		}

		return ordersProducts;
	}

	@Override
	public List<Integer> fillQuantities(Collection<Item> items) {

		List<Integer> listQuantity = new ArrayList<>();

		for (Item item : items) {

			listQuantity.add(item.getQuantity());
		}
		return listQuantity;
	}

	public ProductDTO converterProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setCategory(categoryService.converterCategoryDTO(product.getCategory()));
		productDTO.setDescription(product.getDescription());
		productDTO.setId(product.getId());
		productDTO.setImage(product.getImage());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		productDTO.setVegetarian(product.isVegetarian());
		productDTO.setWeight(product.getWeight());
		return productDTO;

	}

}
