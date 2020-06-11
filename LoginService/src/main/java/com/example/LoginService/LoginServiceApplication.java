package com.example.LoginService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.model.IAMResponse;

@SpringBootApplication
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String,String> var = new LinkedMultiValueMap<String,String>();
		var.add("grant_type" , "urn:ibm:params:oauth:grant-type:apikey");
		var.add("apikey" , "QejCt3tp96xnRdKzfITJxk5sH64ukBZr7sq7vQswX0u-");
		HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<MultiValueMap<String,String>>(var,headers);
	    ResponseEntity<IAMResponse> result = restTemplate.exchange("https://iam.cloud.ibm.com/identity/token",HttpMethod.POST,entity,IAMResponse.class);
	    System.out.println("Service Token:"+result.getBody().getAccess_token());
	    System.out.println("Transaction Token:"+result.getBody().getRefresh_token());
	    System.out.println("Time to live:"+result.getBody().getExpires_in());
	}
	
	
}
