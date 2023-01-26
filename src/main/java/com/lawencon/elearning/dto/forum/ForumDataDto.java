package com.lawencon.elearning.dto.forum;

import java.time.LocalDate;

public class ForumDataDto {

	private Long id;
	private String assetName;
	private String serialNumber;
	private String invoiceCode;
	private LocalDate expiredAt;
	private String typeName;
	private String status;
	private String companyName;
	private String files;
	private String extensions;
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
