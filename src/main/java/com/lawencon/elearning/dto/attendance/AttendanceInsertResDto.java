package com.lawencon.elearning.dto.attendance;

public class AttendanceInsertResDto {

	private AttendanceInsertDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AttendanceInsertDataResDto getData() {
		return data;
	}
	public void setData(AttendanceInsertDataResDto data) {
		this.data = data;
	}
}
