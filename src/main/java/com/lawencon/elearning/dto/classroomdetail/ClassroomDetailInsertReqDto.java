package com.lawencon.elearning.dto.classroomdetail;

import javax.validation.constraints.NotNull;

public class ClassroomDetailInsertReqDto {
	
	@NotNull(message = "field required")
	private Long classroomId;

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}
}
