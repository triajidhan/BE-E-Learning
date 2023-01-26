package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_quiz_collection")
public class QuizCollection extends BaseModel {

	@Column(name = "score")
	private Float score;
	
	@ManyToOne
	@JoinColumn(name = "quiz_schedule_id", nullable = false)
	private QuizSchedule quizSchedule;
	
	@OneToOne
	@JoinColumn(name = "file_id")
	private File file;


	
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public QuizSchedule getQuizSchedule() {
		return quizSchedule;
	}

	public void setQuizSchedule(QuizSchedule quizSchedule) {
		this.quizSchedule = quizSchedule;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
