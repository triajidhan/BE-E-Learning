package com.lawencon.elearning.dto.classroomdetail;

public class ClassroomDetailDataDto {

	private Long id;
	private Long classId;
	private String classroomName;
	private String classroomCode;
	private String classroomDescription;
	private String fullName;
	private Long photoId;
	private Integer version;

	
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public String getClassroomCode() {
		return classroomCode;
	}
	public void setClassroomCode(String classroomCode) {
		this.classroomCode = classroomCode;
	}
	public String getClassroomDescription() {
		return classroomDescription;
	}
	public void setClassroomDescription(String classroomDescription) {
		this.classroomDescription = classroomDescription;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
