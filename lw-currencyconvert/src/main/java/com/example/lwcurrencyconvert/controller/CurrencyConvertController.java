package com.example.lwcurrencyconvert.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.lwcurrencyconvert.service.CurrencyConvertService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/convert")
public class CurrencyConvertController {
	
	/*@Autowired
	CurrencyConvertProxy currencyConvertProxy;*/

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CurrencyConvertService currencyConvertService;
	
	
	@GetMapping("/getConvertedAmount/countryCode/{countryCode}/amount/{amount}")
	public ResponseEntity<String> convertCurrency(@PathVariable("countryCode")String countryCode,@PathVariable("amount") Double amount)
	{
		/*Double conversionFactor = currencyConvertProxy.getConversionFactor(countryCode);*/
		//Double conversionFactor = restTemplate.getForObject("http://conversionFact/getConversionFactor/countryCode/{countryCode}", Double.class,countryCode);
		String convertedAmount = currencyConvertService.convertCurrency(amount, countryCode);
		if(convertedAmount!=null)
		{
			return new ResponseEntity<String>(convertedAmount,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
