package com.myretail.product.price;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface PriceRepository.
 */
public interface PriceRepository extends MongoRepository<Price, String> {

	/**
	 * Find by product id.
	 *
	 * @param id the id
	 * @return the price
	 */
	public Price findByProductId(long id);

}
