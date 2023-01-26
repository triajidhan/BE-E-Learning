package com.lawencon.elearning.dto.quizschedule;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lawencon.elearning.dto.quizattachment.QuizAttachmentInsertReqDto;

public class QuizScheduleUpdateReqDto {

	@NotNull(message = "field required")
	private Long id;
	
	@NotNull(message = "field required")
	private LocalDateTime startTime;
	
	@NotNull(message = "field required")
	private LocalDateTime endTime;
	
	@NotBlank(message = "field required")
	@Size(max = 20)
	private String quizName;
		
	@NotBlank(message = "field required")
	private Long classroomid;
	
	@NotNull(message = "field required")
	@Size(min = 1)
	private List<QuizAttachmentInsertReqDto> quizAttachments;
	
	@NotNull(message = "field required")
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}	
}
