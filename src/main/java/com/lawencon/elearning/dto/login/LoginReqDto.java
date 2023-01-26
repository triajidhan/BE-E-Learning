package com.lawencon.elearning.dto.login;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginReqDto {

	@NotBlank(message = "field required")
	@Size(max = 30)
	private String userEmail;
	
	@NotBlank(message = "field required")
	private String userPassword;

	
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
}
