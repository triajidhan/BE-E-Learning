package com.lawencon.elearning.dto.examschedule;

public class ExamScheduleUpdateResDto {

	private ExamScheduleUpdateDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExamScheduleUpdateDataResDto getData() {
		return data;
	}
	public void setData(ExamScheduleUpdateDataResDto data) {
		this.data = data;
	}
}
