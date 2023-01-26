package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.attendance.AttendanceDto;
import com.lawencon.elearning.dto.attendance.AttendanceInsertReqDto;
import com.lawencon.elearning.dto.attendance.AttendanceInsertResDto;
import com.lawencon.elearning.dto.attendance.AttendanceUpdateReqDto;
import com.lawencon.elearning.dto.attendance.AttendanceUpdateResDto;
import com.lawencon.elearning.dto.attendance.AttendancesDto;

public interface AttendanceService {

	AttendanceInsertResDto studentAttend(AttendanceInsertReqDto data);

	AttendanceUpdateResDto approveAttend(AttendanceUpdateReqDto data);

	AttendanceDto getById(Long id);

	AttendancesDto getMaterial(Long classId);
	
	AttendancesDto getQuiz(Long classId);
	
	AttendancesDto getExam(Long classId);
	
	AttendancesDto getMaterialStudent(Long classId);
	
	AttendancesDto getQuizStudent(Long classId);
	
	AttendancesDto getExamStudent(Long classId);
}
