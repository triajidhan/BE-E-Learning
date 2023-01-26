package com.lawencon.elearning.dto.examcollection;

public class ExamCollectionUpdateResDto {

	private ExamCollectionUpdateDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExamCollectionUpdateDataResDto getData() {
		return data;
	}
	public void setData(ExamCollectionUpdateDataResDto data) {
		this.data = data;
	}
}
