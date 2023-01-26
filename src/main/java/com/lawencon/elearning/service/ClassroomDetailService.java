package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailInsertReqDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailInsertResDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailsDto;

public interface ClassroomDetailService {

	ClassroomDetailInsertResDto chooseClass(ClassroomDetailInsertReqDto data);

	ClassroomDetailDto getById(Long id);

	ClassroomDetailsDto getAll();
	
}
