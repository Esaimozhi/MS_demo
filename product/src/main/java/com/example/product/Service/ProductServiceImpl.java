package com.example.product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.dao.ProductRepository;
import com.example.product.pojo.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository prepo;

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		prepo.save(product);

	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		return prepo.findById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

}
