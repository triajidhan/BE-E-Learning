package com.lawencon.elearning.dto.classroomdetail;

public class ClassroomDetailInsertResDto {

	private ClassroomDetailInsertDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ClassroomDetailInsertDataResDto getData() {
		return data;
	}
	public void setData(ClassroomDetailInsertDataResDto data) {
		this.data = data;
	}
}
