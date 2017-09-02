package com.js.intbuffetproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.js.intbuffetproject.dto.CategoryDTO;
import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Product;

/**
 * Class ConverterProductDTO is used to convert from product to productDTO and vice versa.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Component
public class ConverterProductDTO {
	
	@Autowired
	ConverterCategoryDTO converterCategoryDTO;

	public ProductDTO convertToDTO(Product product) {

		ProductDTO productDTO = new ProductDTO();
		CategoryDTO categoryDTO = converterCategoryDTO.convertToDTO(product.getCategory());
		productDTO.setCategory(categoryDTO);
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

	public Product convertFromDTO(ProductDTO productDTO) {

		Product product = new Product();
		Category category = converterCategoryDTO.convertFromDTO(productDTO.getCategory());
		product.setCategory(category);
		product.setDescription(productDTO.getDescription());
		product.setId(productDTO.getId());
		product.setImage(productDTO.getImage());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setVegetarian(productDTO.isVegetarian());
		product.setWeight(productDTO.getWeight());
		return product;

	}

}
