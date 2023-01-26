package com.lawencon.elearning.dto.attendance;

import java.time.LocalDateTime;

public class AttendanceDataDto {

	private Long id;
	private LocalDateTime attendanceTime;
	private String fullName;
	private String classroomName;
	private String materialName;
	private String quizName;
	private String examName;
	private Boolean atteandance;
	private Integer version;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(LocalDateTime localDateTime) {
		this.attendanceTime = localDateTime;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Boolean getAtteandance() {
		return atteandance;
	}
	public void setAtteandance(Boolean atteandance) {
		this.atteandance = atteandance;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
		
}
