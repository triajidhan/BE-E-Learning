package com.lawencon.elearning.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.constant.Message;
import com.lawencon.elearning.dao.CommentDao;
import com.lawencon.elearning.dao.ForumDao;
import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.dto.comment.CommentDataDto;
import com.lawencon.elearning.dto.comment.CommentDto;
import com.lawencon.elearning.dto.comment.CommentInsertDataResDto;
import com.lawencon.elearning.dto.comment.CommentInsertReqDto;
import com.lawencon.elearning.dto.comment.CommentInsertResDto;
import com.lawencon.elearning.model.Comment;
import com.lawencon.elearning.model.Forum;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.service.CommentService;
import com.lawencon.elearning.service.PrincipalService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PrincipalService principalService;


	@Override
	@Transactional(rollbackOn = Exception.class)
	public CommentInsertResDto insert(final CommentInsertReqDto data) {
		final CommentInsertResDto insertRes = new CommentInsertResDto();
		final CommentInsertDataResDto dataRes = new CommentInsertDataResDto();

		final Comment comment = new Comment();
		comment.setCommentBody(data.getCommentBody());
		
		final Optional<Forum> forumOptional = forumDao.getById(data.getForumId());
		comment.setForum(forumOptional.get());		
		
		comment.setCreatedBy(principalService.getPrincipal().getId());
		final Comment commentInsert = commentDao.insert(comment);	
		
		dataRes.setId(commentInsert.getId());
		insertRes.setData(dataRes);
		insertRes.setMessage(Message.INSERT.getMessageName());

		return insertRes;
	}



	@Override
	public CommentDto getById(final Long id) {
		final Optional<Comment> commentOptional = commentDao.getById(id);
		final CommentDataDto dataDto = new CommentDataDto();
		final CommentDto commentDto = new CommentDto();
		if (commentOptional.isPresent()) {
			dataDto.setId(id);
			dataDto.setClassroomName(commentOptional.get().getForum().getClassroomDetail().getClassroom().getClassroomName());
			final Optional<User> studentOptional = userDao.getById(commentOptional.get().getForum().getCreatedBy());
			dataDto.setStudentName(studentOptional.get().getFullName());
			dataDto.setForumName(commentOptional.get().getForum().getForumName());
			dataDto.setForumBody(commentOptional.get().getForum().getForumBody());
			final Optional<User> teacherOptional = userDao.getById(commentOptional.get().getCreatedBy());
			dataDto.setTeacherName(teacherOptional.get().getFullName());
			dataDto.setCommentBody(commentOptional.get().getCommentBody());
			dataDto.setVersion(commentOptional.get().getVersion());
			commentDto.setData(dataDto);
		}
		return commentDto;	
	}

}
