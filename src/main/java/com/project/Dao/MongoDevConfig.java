package com.project.Dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
	public class MongoDevConfig {

		private final static Logger logger = LoggerFactory.getLogger(MongoDevConfig.class);

		@Bean
		ABC mongoDbFactory() throws Exception {

			logger.debug("Init...... MongoDbFactory() in production mode!");
			
			logger.debug("RAMMM----------------------------------------------------------------------------------------");
			//...
			return new ABC(2, "db");
			
		}

	}
	

