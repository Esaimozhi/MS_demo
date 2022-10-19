package com.example.demoClient.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
Create Table Employee(emp_id int GENERATED AS IDENTITY NOT NULL,name varchar(255),address varchar(255),
constraint PK_empID primary key (emp_id));
*/
@Entity
@Table(name="Employee")
public class Employee {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="emp_id")
		private int emp_id;
		@Column(name = "name")
		private String name;
		@Column(name = "address")
		private String address;
		
		public int getEmp_id() {
			return emp_id;
		}
		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		//Overriding toString() method  
		@Override  
		public String toString() {  
		    return "Employee [emp_id = " + emp_id + ", name = " + name + ", address = " + address  + "]";  
		    }  
}
