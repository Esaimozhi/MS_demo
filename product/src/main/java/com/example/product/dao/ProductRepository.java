package com.example.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.pojo.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
