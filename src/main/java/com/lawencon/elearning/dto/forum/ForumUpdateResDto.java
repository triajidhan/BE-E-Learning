package com.lawencon.elearning.dto.forum;

public class ForumUpdateResDto {

	private ForumUpdateDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ForumUpdateDataResDto getData() {
		return data;
	}
	public void setData(ForumUpdateDataResDto data) {
		this.data = data;
	}
}
