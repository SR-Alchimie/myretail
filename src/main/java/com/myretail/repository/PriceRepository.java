package com.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myretail.product.price.Price;

/**
 * The Interface PriceRepository.
 */
@Repository
public interface PriceRepository extends MongoRepository<Price, String> {
	
	public Price findByProductId(long id);

}