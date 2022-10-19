package com.example.demoClient.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")   
	private String password;
	   //private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
	   
	   public String getPassword() {
	      return password;
	   }
	   public void setPassword(String password) {
	      this.password = password;
	   }

		/*
		 * public Collection<GrantedAuthority> getGrantedAuthoritiesList() { return
		 * grantedAuthoritiesList; } public void
		 * setGrantedAuthoritiesList(Collection<GrantedAuthority>
		 * grantedAuthoritiesList) { this.grantedAuthoritiesList =
		 * grantedAuthoritiesList; }
		 */
	   public String getUsername() {
	      return username;
	   }
	   public void setUsername(String username) {
	      this.username = username;
	   }
}
