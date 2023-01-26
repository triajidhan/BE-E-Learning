package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_quiz")
public class Quiz extends BaseModel {

	@Column(name = "quiz_name", nullable = false, length = 20)
	private String quizName;
	
	@Column(name = "quiz_code", unique = true, nullable = false, length = 5)
	private String quizCode;
	
	@ManyToOne
	@JoinColumn(name = "classroom_id", nullable = false)
	private Classroom classroom;
	
	@ManyToOne
	@JoinColumn(name = "quiz_attachment_id", nullable = false)
	private QuizAttachment quizAttachment;
	
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
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public QuizAttachment getQuizAttachment() {
		return quizAttachment;
	}
	public void setQuizAttachment(QuizAttachment quizAttachment) {
		this.quizAttachment = quizAttachment;
	}
}
