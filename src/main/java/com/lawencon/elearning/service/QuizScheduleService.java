package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.quizschedule.QuizScheduleDeleteResDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleInsertReqDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleInsertResDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleUpdateReqDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleUpdateResDto;
import com.lawencon.elearning.dto.quizschedule.QuizSchedulesDto;

public interface QuizScheduleService {

	QuizScheduleInsertResDto insert(QuizScheduleInsertReqDto data);

	QuizScheduleUpdateResDto update(QuizScheduleUpdateReqDto data);

	QuizScheduleDto getById(Long id);

	QuizSchedulesDto getAll(Long classId);

	QuizScheduleDeleteResDto deleteById(Long id);
}
