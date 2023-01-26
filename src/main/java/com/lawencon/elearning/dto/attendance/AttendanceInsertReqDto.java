package com.lawencon.elearning.dto.attendance;

import javax.validation.constraints.NotNull;

public class AttendanceInsertReqDto {

	
	@NotNull(message = "field required")
	private Long classroomDetailId;
	
	private Long materialScheduleId;
	private Long quizScheduleId;
	private Long examScheduleId;

	
	public Long getClassroomDetailId() {
		return classroomDetailId;
	}
	public void setClassroomDetailId(Long classroomDetailId) {
		this.classroomDetailId = classroomDetailId;
	}
	public Long getMaterialScheduleId() {
		return materialScheduleId;
	}
	public void setMaterialScheduleId(Long materialScheduleId) {
		this.materialScheduleId = materialScheduleId;
	}
	public Long getQuizScheduleId() {
		return quizScheduleId;
	}
	public void setQuizScheduleId(Long quizScheduleId) {
		this.quizScheduleId = quizScheduleId;
	}
	public Long getExamScheduleId() {
		return examScheduleId;
	}
	public void setExamScheduleId(Long examScheduleId) {
		this.examScheduleId = examScheduleId;
	}	
}
