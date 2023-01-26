package com.lawencon.elearning.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_attendance")
public class Attendance extends BaseModel {

	@Column(name = "attendance_time", nullable = false)
	private LocalDateTime attendanceTime;
	
	@ManyToOne
	@JoinColumn(name = "classroom_detail_id", nullable = false)
	private ClassroomDetail classroomDetail;
	
	@ManyToOne
	@JoinColumn(name = "material_schedule_id")
	private MaterialSchedule materialSchedule;
	
	@ManyToOne
	@JoinColumn(name = "quiz_schedule_id")
	private QuizSchedule quizSchedule;
	
	@ManyToOne
	@JoinColumn(name = "exam_schedule_id")
	private ExamSchedule examSchedule;
	
	@Column(name = "attendance", nullable = false)
	private Boolean attendance;
	
	
	public LocalDateTime getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(LocalDateTime attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	public ClassroomDetail getClassroomDetail() {
		return classroomDetail;
	}
	public void setClassroomDetail(ClassroomDetail classroomDetail) {
		this.classroomDetail = classroomDetail;
	}
	public MaterialSchedule getMaterialSchedule() {
		return materialSchedule;
	}
	public void setMaterialSchedule(MaterialSchedule materialSchedule) {
		this.materialSchedule = materialSchedule;
	}
	public QuizSchedule getQuizSchedule() {
		return quizSchedule;
	}
	public void setQuizSchedule(QuizSchedule quizSchedule) {
		this.quizSchedule = quizSchedule;
	}
	public ExamSchedule getExamSchedule() {
		return examSchedule;
	}
	public void setExamSchedule(ExamSchedule examSchedule) {
		this.examSchedule = examSchedule;
	}
	public Boolean getAttendance() {
		return attendance;
	}
	public void setAttendance(Boolean attendance) {
		this.attendance = attendance;
	}

}
