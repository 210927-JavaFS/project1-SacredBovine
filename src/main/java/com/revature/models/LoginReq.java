package com.revature.models;

import java.util.Objects;

public class LoginReq {
	
	private String username;
	private String password;

	public LoginReq() {
		super();
	}
	public LoginReq(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void hashPass() {
		this.password = String.valueOf(this.password.hashCode());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginReq other = (LoginReq) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	@Override
	public String toString() {
		return "LoginReq [" + (username != null ? "userName=" + username + ", " : "")
				+ (password != null ? "password=" + password : "") + "]";
	}
}