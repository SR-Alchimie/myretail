/**
 * 
 */
package com.myretail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration 
@EnableMongoRepositories(basePackages = "com.myretail.repository")
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.host}")
	private String MONGO_DB_HOST;

	@Value("${spring.data.mongodb.port}")
	private int MONGO_DB_PORT;

	@Value("${spring.data.mongodb.database}")
	private String DB;

	@Override
	protected String getDatabaseName() {
		return DB;
	}

	@Bean
	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(MONGO_DB_HOST, MONGO_DB_PORT);
	}

}