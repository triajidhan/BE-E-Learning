package com.lawencon.elearning.dto.forum;

public class ForumInsertResDto {

	private ForumInsertDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ForumInsertDataResDto getData() {
		return data;
	}
	public void setData(ForumInsertDataResDto data) {
		this.data = data;
	}
}
