package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_exam_collection")
public class ExamCollection extends BaseModel {

	@Column(name = "score")
	private Float score;
	
	@ManyToOne
	@JoinColumn(name = "exam_schedule_id", nullable = false)
	private ExamSchedule examSchedule;
	
	@OneToOne
	@JoinColumn(name = "file_id")
	private File file;


	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public ExamSchedule getExamSchedule() {
		return examSchedule;
	}

	public void setExamSchedule(ExamSchedule examSchedule) {
		this.examSchedule = examSchedule;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
