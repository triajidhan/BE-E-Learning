package com.lawencon.elearning.dto.examattachment;

public class ExamAttachmentDataDto {

	private Long id;
	private Long fileId;
	private Integer version;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
		
}
