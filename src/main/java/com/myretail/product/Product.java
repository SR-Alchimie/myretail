package com.myretail.product;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myretail.product.price.Price;

@Document(collection = "product")
@JsonPropertyOrder({ "id", "name" })
public class Product {

	@JsonIgnore
	public String id;

	@JsonProperty("id")
	// @Indexed(unique = true)
	public long productId;

	/** The name. */
	@NotEmpty
	@Length(max = 500)
	public String name;

	public Price price;

	@JsonProperty("current_price")
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Product() {
	}

	public Product(long productId, String name) {
		this.productId = productId;
		this.name = name;

	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Product[productId=%s, name='%s'", productId, name);
	}

}
