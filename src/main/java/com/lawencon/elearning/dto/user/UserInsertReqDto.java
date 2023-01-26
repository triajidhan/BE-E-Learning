package com.lawencon.elearning.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInsertReqDto {

	@NotBlank(message = "field required")
	@Size(max = 30)
	private String fullName;
	
	@NotBlank(message = "field required")
	@Size(max = 30)
	private String userEmail;
	
	@NotBlank(message = "field required")
	private String files;
	
	@NotBlank(message = "field required")
	private String extensions;

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

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}	

}
