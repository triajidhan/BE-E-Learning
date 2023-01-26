package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.QuizScheduleDao;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleDataDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleDeleteResDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleInsertReqDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleInsertResDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleUpdateReqDto;
import com.lawencon.elearning.dto.quizschedule.QuizScheduleUpdateResDto;
import com.lawencon.elearning.dto.quizschedule.QuizSchedulesDto;
import com.lawencon.elearning.model.QuizSchedule;
import com.lawencon.elearning.service.PrincipalService;
import com.lawencon.elearning.service.QuizScheduleService;

@Service
public class QuizScheduleServiceImpl implements QuizScheduleService {

	@Autowired
	private QuizScheduleDao quizScheduleDao;
	@Autowired
	private PrincipalService principalService;	
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public QuizScheduleInsertResDto insert(final QuizScheduleInsertReqDto data) {
		return null;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public QuizScheduleUpdateResDto update(final QuizScheduleUpdateReqDto data) {
		return null;
	}

	@Override
	public QuizScheduleDto getById(final Long id) {
		return null;
	}

	@Override
	public QuizSchedulesDto getAll(Long classId) {
		final List<QuizSchedule> quizSchedules = quizScheduleDao.getAll(principalService.getPrincipal().getId(), classId);
		final List<QuizScheduleDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < quizSchedules.size(); i++) {
			final QuizSchedule quizSchedule = quizSchedules.get(i);
			final QuizScheduleDataDto dataDto = new QuizScheduleDataDto();
			dataDto.setId(quizSchedule.getId());
			dataDto.setQuizName(quizSchedule.getQuiz().getQuizName());
			dataDto.setQuizCode(quizSchedule.getQuiz().getQuizCode());
			dataDto.setStartTime(quizSchedule.getStartTime());
			dataDto.setEndTime(quizSchedule.getEndTime());
			dataDto.setTeacherName(quizSchedule.getQuiz().getClassroom().getTeacher().getFullName());
			dataDto.setClassroomName(quizSchedule.getQuiz().getClassroom().getClassroomName());
			dataDto.setQuizAttachmentId(quizSchedule.getQuiz().getQuizAttachment().getId());
			dataDto.setVersion(quizSchedule.getVersion());
			dataDtos.add(dataDto);
		}
		final QuizSchedulesDto quizSchedulesDto = new QuizSchedulesDto();
		quizSchedulesDto.setData(dataDtos);

		return quizSchedulesDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public QuizScheduleDeleteResDto deleteById(Long id) {
		return null;
	}


}