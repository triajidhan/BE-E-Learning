package com.lawencon.elearning.dto.quizschedule;

public class QuizScheduleUpdateResDto {

	private QuizScheduleUpdateDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public QuizScheduleUpdateDataResDto getData() {
		return data;
	}
	public void setData(QuizScheduleUpdateDataResDto data) {
		this.data = data;
	}
}
