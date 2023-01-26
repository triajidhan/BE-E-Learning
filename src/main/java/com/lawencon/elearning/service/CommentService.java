package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.comment.CommentDto;
import com.lawencon.elearning.dto.comment.CommentInsertReqDto;
import com.lawencon.elearning.dto.comment.CommentInsertResDto;

public interface CommentService {
	
	CommentInsertResDto insert(CommentInsertReqDto data);

	CommentDto getById(Long id);

}
