package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_forum")
public class Forum extends BaseModel {

	@Column(name = "forum_name", nullable = false, length = 100)
	private String forumName;
	
	@Column(name = "forum_body", nullable = false)
	private String forumBody;
	
	@ManyToOne
	@JoinColumn(name = "classroom_detail_id", nullable = false)
	private ClassroomDetail classroomDetail;
	
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumBody() {
		return forumBody;
	}
	public void setForumBody(String forumBody) {
		this.forumBody = forumBody;
	}
	public ClassroomDetail getClassroomDetail() {
		return classroomDetail;
	}
	public void setClassroomDetail(ClassroomDetail classroomDetail) {
		this.classroomDetail = classroomDetail;
	}
}
