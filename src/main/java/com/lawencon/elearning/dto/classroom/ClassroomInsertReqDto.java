package com.lawencon.elearning.dto.classroom;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClassroomInsertReqDto {

	@NotBlank(message = "field required")
	@Size(max = 20)	
	private String classroomName;

	@NotBlank(message = "field required")
	@Size(max = 5)
	private String classroomCode;
	
	@NotBlank(message = "field required")
	private String classroomDescription;
	
	@NotNull(message = "field required")
	private Long teacherId;

	@NotBlank(message = "field required")
	private String files;
	
	@NotBlank(message = "field required")
	private String extensions;


	public String getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	public String getClassroomCode() {
		return classroomCode;
	}

	public void setClassroomCode(String classroomCode) {
		this.classroomCode = classroomCode;
	}

	public String getClassroomDescription() {
		return classroomDescription;
	}

	public void setClassroomDescription(String classroomDescription) {
		this.classroomDescription = classroomDescription;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
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
}
