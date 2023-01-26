package com.lawencon.elearning.dto.quizschedule;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lawencon.elearning.dto.quizattachment.QuizAttachmentInsertReqDto;

public class QuizScheduleInsertReqDto {

	@NotNull(message = "field required")
	private LocalDateTime startTime;
	
	@NotNull(message = "field required")
	private LocalDateTime endTime;
	
	@NotBlank(message = "field required")
	@Size(max = 20)
	private String quizName;
	
	@NotBlank(message = "field required")
	@Size(max = 5)
	private String quizCode;
	
	@NotBlank(message = "field required")
	private Long classroomid;
	
	@NotNull(message = "field required")
	@Size(min = 1)
	private List<QuizAttachmentInsertReqDto> quizAttachments;

	
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

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public List<QuizAttachmentInsertReqDto> getQuizAttachments() {
		return quizAttachments;
	}

	public void setQuizAttachments(List<QuizAttachmentInsertReqDto> quizAttachments) {
		this.quizAttachments = quizAttachments;
	}	
}
