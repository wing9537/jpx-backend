package com.pandora.jpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.pandora.core", "com.pandora.jpx" })
public class JpxApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpxApplication.class, args);
	}

}
