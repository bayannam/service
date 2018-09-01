package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConfigClientAppApplication {
	
	@Autowired
	private ConfigAppConfiguration configAppConfiguration;
	
	@Value("${some.other.property}")
	private String someOtherProperty;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientAppApplication.class, args);
	}
	
	@RequestMapping
	public String getConfiguration() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(configAppConfiguration.getProperty());
		sb.append("||");
		sb.append(someOtherProperty);
		
		return sb.toString();
	}
}
