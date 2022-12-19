package com.helmes.makedon.citylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Yahor Makedon
 */
@SpringBootApplication
public class ApplicationRunner extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunner.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApplicationRunner.class);
	}
}
