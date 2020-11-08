package com.myclass.model;

public class RegisterViewModel {
	private String email;
	private String password;
	private String fullname;
	private String typeRole;
	
	
	public RegisterViewModel(String email, String password, String fullname, String typeRole) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.typeRole = typeRole;
	}


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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTypeRole() {
		return typeRole;
	}

	public void setTypeRole(String typeRole) {
		this.typeRole = typeRole;
	}
	
}
