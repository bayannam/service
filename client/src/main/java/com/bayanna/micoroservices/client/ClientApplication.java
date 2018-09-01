package com.bayanna.micoroservices.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
@RestController
public class ClientApplication {
	
	@Autowired
	private EurekaClient client;
	
	
	//can use discoveryClient as well
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	@GetMapping("/")
	public String getService() {
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		
		InstanceInfo instanceInfo = client.getNextServerFromEureka("service", false);
		
		String homePageUrl = instanceInfo.getHomePageUrl();
		
		ResponseEntity<String> response = restTemplate.exchange(homePageUrl, HttpMethod.GET, null, String.class);
		
		return response.getBody();
	}
}
