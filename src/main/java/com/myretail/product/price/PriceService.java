package com.myretail.product.price;

// TODO: Auto-generated Javadoc
/**
 * The Interface PriceService.
 */
public interface PriceService {

	/**
	 * Gets the price.
	 *
	 * @param id
	 *            the id
	 * @return the price
	 */
	public Price getPrice(long id);

	/**
	 * Creates the.
	 *
	 * @param pPrice
	 *            the price
	 * @return the price
	 */
	public Price create(Price pPrice);

	/**
	 * Updates the.
	 *
	 * @param pPrice
	 *            the price
	 * @return the price
	 */
	public Price update(Price pPrice);

}
