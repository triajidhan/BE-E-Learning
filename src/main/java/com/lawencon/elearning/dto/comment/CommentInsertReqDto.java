package com.lawencon.elearning.dto.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommentInsertReqDto {
	
	@NotBlank(message = "field required")
	private String commentBody;
	
	@NotNull(message = "field required")
	private Long forumId;

	
	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}	
}
