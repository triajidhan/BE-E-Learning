package com.lawencon.elearning.dto.classroom;

public class ClassroomUpdateResDto {

	private ClassroomUpdateDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ClassroomUpdateDataResDto getData() {
		return data;
	}
	public void setData(ClassroomUpdateDataResDto data) {
		this.data = data;
	}
}
