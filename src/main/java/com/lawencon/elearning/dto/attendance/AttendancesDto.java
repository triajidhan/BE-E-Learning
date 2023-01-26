package com.lawencon.elearning.dto.attendance;

import java.util.List;

public class AttendancesDto {

	private List<AttendanceDataDto> data;

	
	public List<AttendanceDataDto> getData() {
		return data;
	}

	public void setData(List<AttendanceDataDto> data) {
		this.data = data;
	}
}
