package com.revature.models;

import java.util.Objects;

public class User {

	private int ersUserID;
	private String ersUserName;
	private String ersPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userRole;
	public User(int ersUserID, String ersUserName, String ersPassword, String userFirstName, String userLastName,
			String userEmail, String userRole) {
		super();
		this.ersUserID = ersUserID;
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}
	public int getErsUserID() {
		return ersUserID;
	}
	public void setErsUserID(int ersUserID) {
		this.ersUserID = ersUserID;
	}
	public String getErsUserName() {
		return ersUserName;
	}
	public void setErsUserName(String ersUserName) {
		this.ersUserName = ersUserName;
	}
	public String getErsPassword() {
		return ersPassword;
	}
	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	
	@Override
	public String toString() {
		return "User [ersUserID=" + ersUserID + ", " + (ersUserName != null ? "ersUserName=" + ersUserName + ", " : "")
				+ (userFirstName != null ? "userFirstName=" + userFirstName + ", " : "")
				+ (userLastName != null ? "userLastName=" + userLastName + ", " : "")
				+ (userEmail != null ? "userEmail=" + userEmail + ", " : "")
				+ (userRole != null ? "userRole=" + userRole : "") + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ersPassword, ersUserID, ersUserName, userEmail, userFirstName, userLastName, userRole);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(ersPassword, other.ersPassword) && ersUserID == other.ersUserID
				&& Objects.equals(ersUserName, other.ersUserName) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userFirstName, other.userFirstName)
				&& Objects.equals(userLastName, other.userLastName) && Objects.equals(userRole, other.userRole);
	}

	
}