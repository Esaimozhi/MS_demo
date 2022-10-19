package com.example.demoClient.service;

import java.util.List;
import java.util.Optional;

import com.example.demoClient.pojo.Employee;
import com.example.demoClient.pojo.Product;

public interface EmployeeService {
	void addEmployee(Employee emp);
	List<Employee> getEmployee();
	Optional<Employee> getEmployee(int id);
	
	// List<Product> getAllProduct();

}
