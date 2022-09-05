package com.loginSignup;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



public class Login {

	private String email;
	private String password ;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

		
	
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}


	
}


	
	




	
	
	

