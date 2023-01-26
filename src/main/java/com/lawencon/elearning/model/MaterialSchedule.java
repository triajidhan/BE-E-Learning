package com.lawencon.elearning.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_material_schedule")
public class MaterialSchedule extends BaseModel {

	@Column(name = "start_time", nullable = false)
	private LocalDateTime startTime;
	
	@Column(name = "end_time", nullable = false)
	private LocalDateTime endTime;
	
	@OneToOne
	@JoinColumn(name = "material_id", nullable = false)
	private Material material;
	
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
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
}
