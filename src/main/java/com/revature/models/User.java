package com.revature.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="ers_user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ers_user_id")
	private int ersUserId;
	@Column (unique=true, name="ers_username")
	private String ersUserName;
	@Column (name="ers_password")
	private String ersPassword;
	@Column (name="user_first_name")
	private String userFirstName;
	@Column (name="user_last_name")
	private String userLastName;
	@Column (name="user_email")
	private String userEmail;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="roleid")//, insertable=false, updatable=false)
	private UserRole userRole;
	
	public User() {
		super();
	}
	
	
	public User(String ersUserName, String ersPassword, String userFirstName, String userLastName, String userEmail,
			UserRole userRole) {
		super();
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}


	public User(int ersUserId, String ersUserName, String ersPassword, String userFirstName, String userLastName,
			String userEmail, UserRole userRole) {
		super();
		this.ersUserId = ersUserId;
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}
	public int getErsUserId() {
		return ersUserId;
	}
	public void setErsUserId(int ersUserID) {
		this.ersUserId = ersUserID;
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
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	
	
	@Override
	public String toString() {
		return "User [ersUserID=" + ersUserId + ", " + (ersUserName != null ? "ersUserName=" + ersUserName + ", " : "")
				+ (userFirstName != null ? "userFirstName=" + userFirstName + ", " : "")
				+ (userLastName != null ? "userLastName=" + userLastName + ", " : "")
				+ (userEmail != null ? "userEmail=" + userEmail + ", " : "")
				+ (userRole != null ? "userRole=" + userRole.toString() : "") + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ersPassword, ersUserId, ersUserName, userEmail, userFirstName, userLastName, userRole);
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
		return Objects.equals(ersPassword, other.ersPassword) && ersUserId == other.ersUserId
				&& Objects.equals(ersUserName, other.ersUserName) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userFirstName, other.userFirstName)
				&& Objects.equals(userLastName, other.userLastName) && Objects.equals(userRole, other.userRole);
	}

	
}