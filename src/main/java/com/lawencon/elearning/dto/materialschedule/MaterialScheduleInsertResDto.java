package com.lawencon.elearning.dto.materialschedule;

public class MaterialScheduleInsertResDto {

	private MaterialScheduleInsertDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MaterialScheduleInsertDataResDto getData() {
		return data;
	}
	public void setData(MaterialScheduleInsertDataResDto data) {
		this.data = data;
	}
}
