package com.myretail.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {

	public Product findByProductId(long productId);

	public List<Product> findByName(String name);

}
