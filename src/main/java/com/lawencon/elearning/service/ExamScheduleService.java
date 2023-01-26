package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.examschedule.ExamScheduleDeleteResDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleInsertReqDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleInsertResDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleUpdateReqDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleUpdateResDto;
import com.lawencon.elearning.dto.examschedule.ExamSchedulesDto;

public interface ExamScheduleService {
	
	ExamScheduleInsertResDto insert(ExamScheduleInsertReqDto data);

	ExamScheduleUpdateResDto update(ExamScheduleUpdateReqDto data);

	ExamScheduleDto getById(Long id);

	ExamSchedulesDto getAll(Long classId);

	ExamScheduleDeleteResDto deleteById(Long id);

}
