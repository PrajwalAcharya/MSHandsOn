package com.example.lwcurrencyconvert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.lwcurrencyconvert.controller.CurrencyConvertProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@RibbonClient(name = "lw-conversion")
public class CurrencyConvertServiceImpl implements CurrencyConvertService {

	@Autowired
	RestTemplate restTemplate;

	/*@Autowired
	CurrencyConvertProxy currencyConvertProxy;*/

	@Autowired
	LoadBalancerClient lbClient;

	@Bean
	@LoadBalanced
	RestTemplate createRestTemplate() {
		RestTemplateBuilder b = new RestTemplateBuilder();
		return b.build();
	}

	@HystrixCommand(fallbackMethod = "convertCurrency_fallback")
	@Override
	public String convertCurrency(Double amount, String countryCode) {

		// Double conversionFactor =
		// currencyConvertProxy.getConversionFactor(countryCode);
		ServiceInstance instance = lbClient.choose("lw-conversion");
		String url = "http://192.168.99.100"+ ":" + instance.getPort()
				+ "/conversionFact/getConversionFactor/countryCode/{countryCode}";
		Double conversionFactor = restTemplate.getForObject(url, Double.class, countryCode);
		Double convertedAmount = amount * conversionFactor;
		return "Converted amount is : " + convertedAmount;
	}

	public String convertCurrency_fallback(Double amount, String countryCode) {

		return "The service is currently unavailable.We are working on the issue.";
	}

}
