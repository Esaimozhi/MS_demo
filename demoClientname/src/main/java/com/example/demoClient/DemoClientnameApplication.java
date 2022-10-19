package com.example.demoClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient  //lives in spring-cloud-netflix and only works for eureka. 
@EnableDiscoveryClient // lives in spring-cloud-commons and picks the implementation on the classpath. If eureka is on your classpath, they are effectively the same.
@EnableFeignClients
//@EnableHystrix
public class DemoClientnameApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoClientnameApplication.class, args);
	}
	
}