package com.example.demoClient.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoClient.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
