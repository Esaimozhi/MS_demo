package com.example.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Service.ProductService;
import com.example.product.pojo.Product;

@RestController
@RequestMapping(value="/")
public class ProductController {
	
	@Autowired
	ProductService psrvc;
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct(){
		return psrvc.getAllProduct();
	}

	@GetMapping("/getProduct/{id}")
	public Optional<Product> getProductById(@PathVariable int id){
		return psrvc.getProductById(id);
	}
	
}
