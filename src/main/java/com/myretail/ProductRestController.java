/**
 * This is the controller class to process the GET and PUT 
 * requests related to the product and it's price
 * @author  Subodh Rawat
 * @version 1.0
 * @since   01/31/2017
 */

package com.myretail;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.common.MyRetailErrorResponse;
import com.myretail.product.Product;
import com.myretail.product.ProductService;
import com.myretail.product.exception.PriceServiceException;
import com.myretail.product.exception.ProductServiceException;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService = null;

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(ProductRestController.class.getName());

	/**
	 * Instantiates a new product rest controller.
	 */
	public ProductRestController() {

	}

	/**
	 * Gets the product.
	 *
	 * @param id
	 *            the id
	 * @return the product
	 */
	@RequestMapping(value = "/api/v1/products/{id}", method = RequestMethod.GET)
	Product getProduct(@PathVariable String id) {
		Product objProduct = null;
		logger.debug("get product details for the product id - " + id);
		validateProductId(id);
		objProduct = productService.getByProductId(Long.parseLong(id));
		return objProduct;
	}

	@RequestMapping(value = "/api/v1/products", method = RequestMethod.POST)
	Product create(@RequestBody Product pProduct) {

		validateProductId(String.valueOf(pProduct.getProductId()));
		Product objProduct = productService.create(pProduct);
		return objProduct;
	}

	private void validateProductId(String id) {

		if (StringUtils.isEmpty(id)) {
			throw new ProductServiceException("Product id is required, it can't be null.");
		}
		if (!StringUtils.isNumeric(id)) {
			throw new ProductServiceException("Product id has to be a a numeric value.");
		}

	}

	@ExceptionHandler({ ProductServiceException.class, PriceServiceException.class })
	public ResponseEntity<MyRetailErrorResponse> exceptionHandler(Exception ex) {

		MyRetailErrorResponse error = new MyRetailErrorResponse();

		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());

		error.setMessage(ex.getMessage());

		return new ResponseEntity<MyRetailErrorResponse>(error, HttpStatus.OK);

	}

}