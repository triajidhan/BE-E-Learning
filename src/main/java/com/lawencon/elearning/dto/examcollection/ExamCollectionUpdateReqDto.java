package com.lawencon.elearning.dto.examcollection;

import javax.validation.constraints.NotNull;

public class ExamCollectionUpdateReqDto {

	@NotNull(message = "field required")
	private Long id;

	private Float score;	
	private String files;	
	private String extensions;
	
	@NotNull(message = "field required")
	private Integer version;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
