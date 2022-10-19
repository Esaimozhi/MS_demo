package com.example.demoClient.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoClient.pojo.Employee;
import com.example.demoClient.pojo.Product;
import com.example.demoClient.service.EmployeeService;


@RestController
@RequestMapping //(value= "/")
public class EmployeeController {
	
	@Autowired(required=true)
	EmployeeService empService;
		
	@GetMapping(value= "/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return empService.getEmployee();
		
	}
	
	@GetMapping(value= "/getEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id){
		return empService.getEmployee(id);
		
	}


	
	@PostMapping (value= "/addemp")
	public void saveEmployee(@RequestBody Employee emp) {
		empService.addEmployee(emp);
	}
	
	/*
	 * POST : localhost:8762/addemp { "Id":3, "name": "mathi", "address":
	 * "Hosur-IIT" }
	 */
	

 	@GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
	  return null;// empService.getAllProduct();
 	}

 
}
