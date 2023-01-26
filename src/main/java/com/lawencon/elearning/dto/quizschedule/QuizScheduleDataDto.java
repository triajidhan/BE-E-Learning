package com.lawencon.elearning.dto.quizschedule;

import java.time.LocalDateTime;

public class QuizScheduleDataDto {

	private Long id;
	private String quizName;
	private String quizCode;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String classroomName;
	private String teacherName;
	private Long quizAttachmentId;
	private Integer version;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public String getQuizCode() {
		return quizCode;
	}
	public void setQuizCode(String quizCode) {
		this.quizCode = quizCode;
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
	public Long getQuizAttachmentId() {
		return quizAttachmentId;
	}
	public void setQuizAttachmentId(Long quizAttachmentId) {
		this.quizAttachmentId = quizAttachmentId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
