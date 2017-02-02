package com.myretail.product;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Gets the by product id.
	 *
	 * @param id
	 *            the id
	 * @return the by product id
	 */
	public Product getByProductId(final long id);

	/**
	 * Creates the.
	 *
	 * @param product
	 *            the product
	 * @return the product
	 */
	public Product create(Product product);

	/**
	 * Delete.
	 *
	 * @param id
	 *            the productId
	 * @return the product
	 */
	public Product delete(final long productId);

	/**
	 * Update.
	 *
	 * @param product
	 *            the product
	 * @return the product
	 */
	public Product update(Product product);
}
