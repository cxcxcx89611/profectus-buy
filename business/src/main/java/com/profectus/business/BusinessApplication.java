package com.profectus.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BusinessApplication {

	private static final Logger LOG = LoggerFactory.getLogger(com.profectus.business.BusinessApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(com.profectus.business.BusinessApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("business application start！！");
		LOG.info("Business host: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}

}
