package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.classroom.ClassroomDeleteResDto;
import com.lawencon.elearning.dto.classroom.ClassroomDto;
import com.lawencon.elearning.dto.classroom.ClassroomInsertReqDto;
import com.lawencon.elearning.dto.classroom.ClassroomInsertResDto;
import com.lawencon.elearning.dto.classroom.ClassroomUpdateReqDto;
import com.lawencon.elearning.dto.classroom.ClassroomUpdateResDto;
import com.lawencon.elearning.dto.classroom.ClassroomsDto;

public interface ClassroomService {
	
	ClassroomInsertResDto insert(ClassroomInsertReqDto data);

	ClassroomUpdateResDto update(ClassroomUpdateReqDto data);

	ClassroomDto getById(Long id);

	ClassroomsDto getAll();

	ClassroomDeleteResDto deleteById(Long id);

}
