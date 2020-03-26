package com.myproj.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderV1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderV1Application.class, args);
	}

}
