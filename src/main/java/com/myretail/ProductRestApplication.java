package com.myretail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductRestApplication.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class ProductRestApplication implements CommandLineRunner {

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(ProductRestApplication.class.getName());

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductRestApplication.class, args);
	}

	/**
	 * Run.
	 *
	 * @param args
	 *            the args
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public void run(String... args) throws Exception {

		logger.debug("Inside  productRestApplication");
		// repository.deleteAll();

		// save a couple of customers
		// repository.save(new Product(13860428, "The Big Lebowski (Blu-ray)
		// (Widescreen)"));
		// repository.save(new Product(15117729, "The Matrix"));
		// repository.save(new Product(16483589,"Three"));
		// repository.save(new Product(16696652,"FOur"));
		// repository.save(new Product(16752456,"Five"));
		// repository.save(new Product(15643793,"Six"));

		// fetch all customers
		// System.out.println("Inside productRestApplication");
		// System.out.println("-------------------------------");
		// for (Product product : repository.findAll()) {
		// System.out.println(product);
		// }
		// System.out.println();
		//
		// // fetch an individual customer
		// System.out.println("Product found with findByName('FOur'):");
		// System.out.println("--------------------------------");
		// System.out.println(repository.findByName("FOur"));
		//
		// System.out.println("Product found with findById(15643793):");
		// System.out.println("--------------------------------");
		// System.out.println(repository.findByProductId(15643793));

		// priceRepo.deleteAll();
		//
		//// // save a couple of customers
		// priceRepo.save(new Price(13860428, 13.99));
		// priceRepo.save(new Price(15117729, 9.99));
		// priceRepo.save(new Price(16483589,11.99));
		// priceRepo.save(new Price(16696652,12.35));
		// priceRepo.save(new Price(16752456,15.89));
		// priceRepo.save(new Price(15643793,4.50));

		// for (Price price : priceRepo.findAll()) {
		// System.out.println("Price is - " + price);
		// }

	}

}
