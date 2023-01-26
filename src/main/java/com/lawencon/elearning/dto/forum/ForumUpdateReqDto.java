package com.lawencon.elearning.dto.forum;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ForumUpdateReqDto {

	@NotNull(message = "field required")
	private Long id;
	
	@NotBlank(message = "field required")
	@Size(max = 20)
	private String assetName;
	
	private LocalDate expiredAt;
	
	@NotNull(message = "field required")
	private Long assetTypeId;
	
	@NotNull(message = "field required")
	private Long companyId;
	
	@NotNull(message = "field required")
	private Long brandId;
	
	@NotNull(message = "field required")
	private Long statusId;
	
	@NotBlank(message = "field required")
	private String files;
	
	@NotBlank(message = "field required")
	private String extensions;
	
	@NotNull(message = "field required")
	private Integer version;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public LocalDate getExpiredAt() {
		return expiredAt;
	}
	public void setExpiredAt(LocalDate expiredAt) {
		this.expiredAt = expiredAt;
	}
	public Long getAssetTypeId() {
		return assetTypeId;
	}
	public void setAssetTypeId(Long assetTypeId) {
		this.assetTypeId = assetTypeId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
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
