package com.example.demoClient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demoClient.pojo.Product;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@FeignClient(name="PRODUCT-SERVICE")
@RibbonClient(name="PRODUCT-SERVICE") 
public interface ProductConsumer {
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct();
	
	@GetMapping("/getProduct/{id}")
	public Optional<Product> getProductById(@PathVariable Integer id);
	
	/*
	 //Implement Hystrix with fallback method
	//implemented FeignClient	
		
		
		
		//@HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
		
		// enable fallback and tread pool
			@HystrixCommand(fallbackMethod= "fallbackProduct" , 
							threadPoolKey="itemByUserThreadPool",
				threadPoolProperties= {@HystrixProperty(name="coreSize",value="30"),@HystrixProperty(name="maxQueueSize",value="10")})
			
	//fallback method
			
			private Product fallbackProduct()
			{
				Product product =new Product();
				product.setId(111);
				product.setName("TestName");
				product.setPrice(121);
				return product;
			}
	 */

}
