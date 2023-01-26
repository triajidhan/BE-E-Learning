package com.lawencon.elearning.dto.examattachment;

import javax.validation.constraints.NotBlank;

public class ExamAttachmentInsertReqDto {
	
	@NotBlank(message = "field required")
	private String files;
	
	@NotBlank(message = "field required")
	private String extensions;

	
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
}
