package com.myretail.product.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.product.exception.ProductServiceException;
import com.myretail.repository.PriceRepository;
import com.myretail.resource.Messages;

/**
 * The Class PriceServiceImpl.
 */
@Service
public class PriceServiceImpl implements PriceService {

	/** The price repository. */
	@Autowired
	private PriceRepository priceRepository;

	/** The price messages. */
	@Autowired
	Messages priceMessages;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.myretail.product.price.PriceService#getPrice(long)
	 */
	public Price getPrice(long id) {
		Price objPrice = null;

		System.out.println("ID is " + id);
		// this.validateProductId(id);
		System.out.println("Inside PriceServiceImpl - ID after validation  " + id);
		try {

			objPrice = priceRepository.findByProductId(id);
			if (objPrice != null) {
				System.out.println("Inside PriceServiceImpl - price obj is not null  " + objPrice);

				System.out.println("Price found is   " + objPrice.toString());
				objPrice.setCurrency_code(getCurrencyCodeBasedOnLocal());
			} else {
				System.out.println("Product not found");
				throw new ProductServiceException("Product id not found " + id);
			}
		} catch (NumberFormatException numException) {
			throw new NumberFormatException("Product id has to be a number");
		}
		return objPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.myretail.product.price.PriceService#create(com.myretail.product.price
	 * .Price)
	 */
	public Price create(Price pPrice) {
		priceRepository.save(pPrice);
		return pPrice;
	}

	/**
	 * Gets the currency code based on local.
	 *
	 * @return the currency code based on local
	 */
	/* to be implemented to get the local currency from Properties file. */
	private String getCurrencyCodeBasedOnLocal() {
		return "USD";
	}

}