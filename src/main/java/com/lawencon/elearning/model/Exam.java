package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_exam")
public class Exam extends BaseModel {

	@Column(name = "exam_name", nullable = false, length = 20)
	private String examName;
	
	@Column(name = "exam_code", unique = true, nullable = false, length = 20)
	private String examCode;
	
	@ManyToOne
	@JoinColumn(name = "classroom_id", nullable = false)
	private Classroom classroom;
	
	@ManyToOne
	@JoinColumn(name = "exam_attachment_id", nullable = false)
	private ExamAttachment examAttachment;
	
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
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public ExamAttachment getExamAttachment() {
		return examAttachment;
	}
	public void setExamAttachment(ExamAttachment examAttachment) {
		this.examAttachment = examAttachment;
	}
}
