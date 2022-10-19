package com.example.demoClient.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoClient.pojo.Users;

public interface OAuthDao extends JpaRepository<Users, Integer>{
	
 Optional<Users> findByUsername(String username); 
	

}
