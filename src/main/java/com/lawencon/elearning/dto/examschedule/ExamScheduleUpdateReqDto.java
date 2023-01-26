package com.lawencon.elearning.dto.examschedule;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lawencon.elearning.dto.examattachment.ExamAttachmentInsertReqDto;

public class ExamScheduleUpdateReqDto {

	@NotNull(message = "field required")
	private Long id;
	
	@NotNull(message = "field required")
	private LocalDateTime startTime;
	
	@NotNull(message = "field required")
	private LocalDateTime endTime;
	
	@NotBlank(message = "field required")
	@Size(max = 20)
	private String examName;
		
	@NotBlank(message = "field required")
	private Long classroomid;
	
	@NotNull(message = "field required")
	@Size(min = 1)
	private List<ExamAttachmentInsertReqDto> examAttachments;
	
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

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public List<ExamAttachmentInsertReqDto> getExamAttachments() {
		return examAttachments;
	}

	public void setExamAttachments(List<ExamAttachmentInsertReqDto> examAttachments) {
		this.examAttachments = examAttachments;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}	
}
