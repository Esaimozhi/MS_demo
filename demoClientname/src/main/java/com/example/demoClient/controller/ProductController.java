package com.example.demoClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoClient.pojo.Product;
import com.example.demoClient.service.ProductConsumer;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductConsumer pc;
	
			@GetMapping("/getAllProduct")
			public List<Product>getAllProduct(){
				return pc.getAllProduct();
				
			}
	
		

}
