package com.lawencon.elearning.dto.user;

public class UserInsertResDto {

	private UserInsertDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserInsertDataResDto getData() {
		return data;
	}
	public void setData(UserInsertDataResDto data) {
		this.data = data;
	}
}
