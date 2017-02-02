package com.myretail.product.price;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class Price.
 */
@Document(collection = "price")
@JsonPropertyOrder({ "value", "currency_code" })
public class Price {

	/** The id. */
	@JsonIgnore
	public String id;

	/** The product id. */
	@JsonIgnore
	public long productId;

	/** The currency code. */
	public String currency_code = "USD";

	/** The value. */
	public double value;

	/**
	 * Instantiates a new price.
	 */
	public Price() {
	}

	/**
	 * Instantiates a new price.
	 *
	 * @param productId
	 *            the product id
	 * @param value
	 *            the value
	 * @param currency_code
	 *            the currency code
	 */
	public Price(long productId, double value, String currency_code) {
		this.productId = productId;
		this.value = value;
		this.currency_code = currency_code;
	}

	/**
	 * Gets the currency code.
	 *
	 * @return the currency code
	 */
	public String getCurrency_code() {
		return currency_code;
	}

	/**
	 * Sets the currency code.
	 *
	 * @param currency_code
	 *            the new currency code
	 */
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Product[id=%s, value='%s', currency_code='%s']", productId, value, currency_code);
	}

}