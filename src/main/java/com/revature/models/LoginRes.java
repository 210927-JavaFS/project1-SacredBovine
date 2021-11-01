package com.revature.models;

import java.util.Objects;

public class LoginRes {

	private int id;
	private String name;
	private int role;
	
	public LoginRes() {
		super();
	}
	public LoginRes(int id, String name, int role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, role);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginRes other = (LoginRes) obj;
		return id == other.id && Objects.equals(name, other.name) && role == other.role;
	}
	
	@Override
	public String toString() {
		return "LoginRes [id=" + id + ", " + (name != null ? "name=" + name + ", " : "") + "role=" + role + "]";
	}
}