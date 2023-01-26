package com.lawencon.elearning.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_classroom_detail")
public class ClassroomDetail extends BaseModel {

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private User student;
	
	@ManyToOne
	@JoinColumn(name = "classroom_id", nullable = false)
	private Classroom classroom;
	
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
}
