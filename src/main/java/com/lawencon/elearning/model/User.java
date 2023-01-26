package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_user", uniqueConstraints = 
@UniqueConstraint(
		name = "user_ck",
		columnNames = {"user_email", "user_password"}
	))
public class User extends BaseModel {

	@Column(name = "full_name", nullable = false, length = 30)
	private String fullName;
	
	@Column(name = "user_email", unique = true, nullable = false, length = 30)
	private String userEmail;
	
	@Column(name = "user_password", nullable = false)
	private String userPassword;
	
	@ManyToOne
	@JoinColumn(name = "photo_id", nullable = false)
	private File photo;
	
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
