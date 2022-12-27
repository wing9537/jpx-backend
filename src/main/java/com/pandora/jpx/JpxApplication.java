package com.pandora.jpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class JpxApplication {

	public static void main(String[] args) {
		System.out.println("App Started.");
		SpringApplication.run(JpxApplication.class, args);
	}

}
