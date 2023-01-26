package com.lawencon.elearning.dto.comment;

public class CommentUpdateResDto {

	private CommentUpdateDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CommentUpdateDataResDto getData() {
		return data;
	}
	public void setData(CommentUpdateDataResDto data) {
		this.data = data;
	}
}
