package com.myretail;

import com.myretail.product.Product;
import com.myretail.product.price.Price;

public class RequestData {

	public Product product;

	public Price price;

	public RequestData() {
	}

	public RequestData(Product product) {
		this.product = product;

	}

	public RequestData(Product product, Price price) {
		this.product = product;
		this.price = price;

	}

}