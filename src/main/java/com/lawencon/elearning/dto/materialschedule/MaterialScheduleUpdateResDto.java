package com.lawencon.elearning.dto.materialschedule;

public class MaterialScheduleUpdateResDto {

	private MaterialScheduleUpdateDataResDto data;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MaterialScheduleUpdateDataResDto getData() {
		return data;
	}
	public void setData(MaterialScheduleUpdateDataResDto data) {
		this.data = data;
	}
}
