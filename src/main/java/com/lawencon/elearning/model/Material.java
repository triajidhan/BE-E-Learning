package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_material")
public class Material extends BaseModel {

	@Column(name = "material_name", nullable = false, length = 20)
	private String materialName;
	
	@Column(name = "material_code", unique = true, nullable = false, length = 5)
	private String materialCode;
	
	@ManyToOne
	@JoinColumn(name = "classroom_id", nullable = false)
	private Classroom classroom;
	
	@ManyToOne
	@JoinColumn(name = "material_attachment_id", nullable = false)
	private MaterialAttachment materialAttachment;
	
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public MaterialAttachment getMaterialAttachment() {
		return materialAttachment;
	}
	public void setMaterialAttachment(MaterialAttachment materialAttachment) {
		this.materialAttachment = materialAttachment;
	}
	
}
