package com.ibm.lwconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LwConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LwConversionApplication.class, args);
	}

}
