package com.lawencon.elearning.dto.examschedule;

public class ExamScheduleInsertResDto {

	private ExamScheduleInsertDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExamScheduleInsertDataResDto getData() {
		return data;
	}
	public void setData(ExamScheduleInsertDataResDto data) {
		this.data = data;
	}
}
