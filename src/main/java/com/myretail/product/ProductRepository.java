package com.myretail.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {

	public Product findByProductId(long productId);

	@Query(value = "{ $or: [ { 'productId' : ?0 }, { 'name' : ?1 } ] }")
	public Product findByProductIdAndName(long productId, String name);

	public List<Product> findByName(String name);

}