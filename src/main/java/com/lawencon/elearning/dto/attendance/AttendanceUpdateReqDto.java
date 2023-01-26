package com.lawencon.elearning.dto.attendance;

import javax.validation.constraints.NotNull;

public class AttendanceUpdateReqDto {

	@NotNull(message = "field required")
	private Long id;
	
	@NotNull(message = "field required")
	private Integer version;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
