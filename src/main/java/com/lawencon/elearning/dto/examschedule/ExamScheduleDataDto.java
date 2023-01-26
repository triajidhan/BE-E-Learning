package com.lawencon.elearning.dto.examschedule;

import java.time.LocalDateTime;

public class ExamScheduleDataDto {

	private Long id;
	private String examName;
	private String examCode;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String classroomName;
	private String teacherName;
	private Long examAttachmentId;
	private Integer version;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
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
	public Long getExamAttachmentId() {
		return examAttachmentId;
	}
	public void setExamAttachmentId(Long examAttachmentId) {
		this.examAttachmentId = examAttachmentId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
