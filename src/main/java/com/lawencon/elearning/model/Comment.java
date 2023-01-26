package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_comment")
public class Comment extends BaseModel {

	@Column(name = "comment_body", nullable = false)
	private String commentBody;
	
	@ManyToOne
	@JoinColumn(name = "forum_id", nullable = false)
	private Forum forum;
	
	public String getCommentBody() {
		return commentBody;
	}
	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
}
