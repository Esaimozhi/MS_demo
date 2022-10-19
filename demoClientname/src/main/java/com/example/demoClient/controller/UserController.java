package com.example.demoClient.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoClient.pojo.Users;
import com.example.demoClient.service.UsersService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired(required=true)
	
	UsersService usrService;
	
	@GetMapping(value= "/getAllUser")
	public List<Users> getUsers(){
		return usrService.getAllUsers();
		
	}
	// localhost:8762/user/getUser/mathi
	@GetMapping(value= "/getUser/{name}")
	public Optional<Users> loadUserByUsername(@PathVariable String name){
		return usrService.loadUserByUsername(name);
		
	}
	
	@RequestMapping(value = "/puser")
	   public Principal user(Principal principal) {
	      return principal;
	   }

}
