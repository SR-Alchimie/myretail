package com.myretail.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.product.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	public Product findByProductId(long productId);

	public List<Product> findByName(String name);

	public Product findByProductIdAndName(long productId, String name);
}