package com.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.product.price.Price;

// TODO: Auto-generated Javadoc
/**
 * The Interface PriceRepository.
 */
public interface PriceRepository extends MongoRepository<Price, String> {

	/**
	 * Find by product id.
	 *
	 * @param id
	 *            the id
	 * @return the price
	 */
	public Price findByProductId(long id);

}