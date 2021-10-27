package com.revature.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="ers_user_roles")
public class UserRole {
	
	@Id
	@Column (name="ers_user_role_id")
	private int roleId;
	@Column (name="user_role")
	private String role;
	public UserRole() {
		super();
	}
	public UserRole(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		return Objects.hash(role, roleId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return Objects.equals(role, other.role) && roleId == other.roleId;
	}
	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", " + (role != null ? "role=" + role : "") + "]";
	}

	
}
