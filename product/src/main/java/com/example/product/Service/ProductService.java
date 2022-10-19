package com.example.product.Service;

import java.util.List;
import java.util.Optional;

import com.example.product.pojo.Product;

public interface ProductService {
	void addProduct(Product product);
	Optional<Product> getProductById(int id);
	List<Product> getAllProduct();
	

}
