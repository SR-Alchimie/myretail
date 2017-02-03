/**
 * 
 */
package com.myretail.common;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.myretail.product.Product;
import com.myretail.product.exception.PriceServiceException;
import com.myretail.product.exception.ProductServiceException;
import com.myretail.product.price.Price;

/**
 * @author subodhrawat
 *
 */
@Component
public class ValidationUtils {

	public static void validateProductDetails(Product product) {

		// product price can't be null
		if (product == null) {
			throw new PriceServiceException("No product information found to save.");
		}
		// check if the price is less then zero.
		else if (product.getProductId() <= 0) {
			throw new PriceServiceException(
					"Product Id cannot be negative or zero. Product id passed is :-" + product.getProductId());
		}
		// check if the name is blank then zero.
		else if (StringUtils.isBlank(product.getName())) {
			throw new PriceServiceException("Product Id cannot be negative or zero.");
		}
		// added restriction for the length
		else if (product.name.length() > 250) {
			throw new PriceServiceException("Product name should not be greated then 250 characters.");
		}
	}

	public static void validatePriceDetails(Price price) {

		// product price can't be null
		if (price == null) {
			throw new PriceServiceException("Price is missing for the product");
		}
		// check if the price is less then zero.
		if (price.getValue() < 0) {
			throw new PriceServiceException("Price cannot be negative for the product.");
		}
	}

	/**
	 * @param productId
	 */
	public static void validateProductId(String id) {

		if (StringUtils.isEmpty(id)) {
			throw new ProductServiceException("Product id is required, it can't be null.");
		}
		
		try {
			
			validateProductId(Long.parseLong(id));
		} catch (NumberFormatException e) {
			throw new ProductServiceException("Product id is required, it can't be null.");
		}
	}
	
	/**
	 * @param productId
	 */
	public static void validateProductId(long productId) {
		if (productId <= 0) {
			throw new PriceServiceException(
					"Product Id cannot be negative or zero. Product id passed is :-" + productId);
		}

	}
}
