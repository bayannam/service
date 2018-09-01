package com.bayanna.micoroservices.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	
	@Value("${service.instance.name}")
	private String instance;
	
	
	@RequestMapping("/")
	//@RequestMapping
	//@GetMapping("/")
	public String getMessage(){
		
		return "Hello from"+instance;
	}

}
