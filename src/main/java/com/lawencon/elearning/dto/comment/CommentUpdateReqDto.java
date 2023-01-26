package com.lawencon.elearning.dto.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommentUpdateReqDto {

	@NotNull(message = "field required")
	private Long id;
		
	@NotBlank(message = "field required")
	private String commentBody;
	
	@NotNull(message = "field required")
	private Integer version;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
