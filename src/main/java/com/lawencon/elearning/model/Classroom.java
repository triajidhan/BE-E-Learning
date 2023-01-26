package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_classroom")
public class Classroom extends BaseModel {

	@Column(name = "classroom_name", nullable = false, length = 20)
	private String classroomName;
	
	@Column(name = "classroom_code", unique = true, nullable = false, length = 5)
	private String classroomCode;
	
	@Column(name = "classroom_description", nullable = false)
	private String classroomDescription;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false)
	private User teacher;
	
	@ManyToOne
	@JoinColumn(name = "photo_id", nullable = false)	
	private File photo;
	
	
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
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
}
