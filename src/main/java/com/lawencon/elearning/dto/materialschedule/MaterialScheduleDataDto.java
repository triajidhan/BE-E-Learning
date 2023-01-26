package com.lawencon.elearning.dto.materialschedule;

import java.time.LocalDateTime;

public class MaterialScheduleDataDto {

	private Long id;
	private String materialName;
	private String materialCode;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String classroomName;
	private String teacherName;
	private Long materialAttachmentId;
	private Integer version;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Long getMaterialAttachmentId() {
		return materialAttachmentId;
	}
	public void setMaterialAttachmentId(Long materialAttachmentId) {
		this.materialAttachmentId = materialAttachmentId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}	
}
