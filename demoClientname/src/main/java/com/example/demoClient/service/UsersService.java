package com.example.demoClient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoClient.dao.OAuthDao;

import com.example.demoClient.pojo.Users;
@Service
public class UsersService {
	@Autowired(required=true)
	OAuthDao oauthDao;
	
	List<Users> empList = new ArrayList<>();
	
	  
	public Optional<Users> loadUserByUsername(String username) {
		
		return oauthDao.findByUsername(username);}


	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return oauthDao.findAll();
	}
	
}
