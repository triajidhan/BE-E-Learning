package com.lawencon.elearning.dto.forum;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ForumInsertReqDto {

	@NotBlank(message = "field required")
	@Size(max = 20)
	private String assetName;
	
	@NotBlank(message = "serial number duplicated")
	@Size(max = 50)
	private String serialNumber;
	
	@NotBlank(message = "field required")
	@Size(max = 50)
	private String invoiceCode;
	
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
	
	
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
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
}
