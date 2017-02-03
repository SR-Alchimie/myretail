package com.myretail.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.common.ValidationUtils;
import com.myretail.product.exception.PriceServiceException;
import com.myretail.product.exception.ProductServiceException;
import com.myretail.product.price.Price;
import com.myretail.product.price.PriceService;
import com.myretail.repository.ProductRepository;

/**
 * The Class ProductServiceImpl will create a new product details passed and get
 * the product details based on the product id.
 * 
 */
@Service
// @Resource(name = "v1")
class ProductServiceImpl implements ProductService {

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class.getName());

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	
	/** The price service. */
	@Autowired
	private PriceService priceService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.myretail.product.ProductService#getByProductId(long)
	 */
	public Product getByProductId(long productId) {
		Product objProduct = null;
		Price objPrice = null;

		logger.debug("Product id is   " + productId);
		ValidationUtils.validateProductId(productId);
		try {
			if (productRepository != null) {
				logger.debug("Inside if (productRepository != null)  productRepository " + productRepository);

				objProduct = productRepository.findByProductId(productId);
				if (objProduct != null) {
					objPrice = priceService.getPrice(productId);
					if (objPrice != null) {
						logger.debug("Inside if (objPrice != null) - price " + objPrice.toString());
						objProduct.setPrice(objPrice);
					} else {

						logger.debug("Price not found for product " + productId);
						throw new PriceServiceException("Price not found for product " + productId);
					}

					System.out.println("Product and Price found is   " + objProduct.toString());

				} else {
					System.out.println("Product not found");
					throw new ProductServiceException("Product not found - " + productId);
				}
			} else {

				logger.error("productRepository  is null " + productRepository);
			}

		} catch (NumberFormatException numException) {
			throw new ProductServiceException("The 'productId' parameter must be a number :- " + productId);
		}

		return objProduct;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.myretail.product.ProductService#create(com.myretail.product.Product)
	 */
	public Product create(Product product) {

		logger.debug("Inside the create method");

		ValidationUtils.validateProductDetails(product);
		ValidationUtils.validatePriceDetails(product.getPrice());

		logger.debug("Product details to create - " + product.toString());

		// check the db if the product name already exists, if no go ahead to
		// save the product details
		if (productRepository.findByName(product.getName()) == null
				|| productRepository.findByName(product.getName()).isEmpty()) {
			try {
				// save the product DB, while saving db has the unique key on
				// productId.
				productRepository.save(product);
				// save the product and price details in DB
				try {
					product.getPrice().setProductId(product.getProductId());
					priceService.create(product.getPrice());
				} catch (Exception excePrice) {

					throw new PriceServiceException(
							"Error while saving the price information for :-" + product.getProductId());

				}

			} catch (Exception exceProduct) {

				throw new ProductServiceException("Product already exists with productId :- " + product.getProductId());
			}

		} else {
			throw new ProductServiceException("Product already exists with name :- " + product.getName());
		}
		return product;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.myretail.product.ProductService#update(com.myretail.product.Product)
	 */
	public Product update(Product product) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.myretail.product.ProductService#update(com.myretail.product.Product)
	 */
	public Product delete(final long productId) {
		return null;
	}

}