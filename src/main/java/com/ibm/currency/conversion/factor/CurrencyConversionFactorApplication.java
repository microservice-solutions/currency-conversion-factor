package com.ibm.currency.conversion.factor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class CurrencyConversionFactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionFactorApplication.class, args);
	}

}
