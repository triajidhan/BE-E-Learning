package com.lawencon.elearning.dto.classroom;

public class ClassroomInsertResDto {

	private ClassroomInsertDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ClassroomInsertDataResDto getData() {
		return data;
	}
	public void setData(ClassroomInsertDataResDto data) {
		this.data = data;
	}
}
