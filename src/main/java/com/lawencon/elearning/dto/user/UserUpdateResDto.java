package com.lawencon.elearning.dto.user;

public class UserUpdateResDto {

	private UserUpdateDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserUpdateDataResDto getData() {
		return data;
	}
	public void setData(UserUpdateDataResDto data) {
		this.data = data;
	}
}
