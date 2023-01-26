package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_file")
public class File extends BaseModel {

	@Column(name = "files", nullable = false)
	private String files;
	
	@Column(name = "extensions", nullable = false, length = 5)
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
