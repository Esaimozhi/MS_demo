package com.example.demoClient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demoClient.dao.EmployeeRepository;
import com.example.demoClient.pojo.Employee;
import com.example.demoClient.pojo.Product;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
		
	//@Autowired
	//private product product;
	
	List<Employee> empList = new ArrayList<>();

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
        repo.save(emp);
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
