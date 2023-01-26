package com.lawencon.elearning.dto.materialschedule;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lawencon.elearning.dto.materialattachment.MaterialAttachmentInsertReqDto;

public class MaterialScheduleUpdateReqDto {

	@NotNull(message = "field required")
	private Long id;
	
	@NotNull(message = "field required")
	private LocalDateTime startTime;
	
	@NotNull(message = "field required")
	private LocalDateTime endTime;
	
	@NotBlank(message = "field required")
	@Size(max = 20)
	private String materialName;
		
	@NotBlank(message = "field required")
	private Long classroomid;
	
	@NotNull(message = "field required")
	@Size(min = 1)
	private List<MaterialAttachmentInsertReqDto> materialAttachments;
	
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

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public List<MaterialAttachmentInsertReqDto> getMaterialAttachments() {
		return materialAttachments;
	}

	public void setMaterialAttachments(List<MaterialAttachmentInsertReqDto> materialAttachments) {
		this.materialAttachments = materialAttachments;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
