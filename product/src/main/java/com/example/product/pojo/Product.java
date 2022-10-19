package com.example.product.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")

/*
 * create table NYSHIP_RPT.Product (
   id             NUMBER GENERATED AS IDENTITY NOT NULL,
   name  VARCHAR(15)           not null,
   price int
   
)
   tablespace NYSHIP_RPT_DATA;
   
   insert into NYSHIP_RPT.Product(name, price) values('WSTEST',5);
    commit;
 */
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private  int id;
	@Column
	private  String name;
	@Column
	private  double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	//Overriding toString() method  
		@Override  
		public String toString() {  
		    return "Product [Product_id = " + id + ", name = " + name + ", Price = " + price  + "]";  
		    } 
	

}
