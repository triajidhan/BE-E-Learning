package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.constant.Message;
import com.lawencon.elearning.dao.ClassroomDao;
import com.lawencon.elearning.dao.ExamAttachmentDao;
import com.lawencon.elearning.dao.ExamDao;
import com.lawencon.elearning.dao.ExamScheduleDao;
import com.lawencon.elearning.dao.FileDao;
import com.lawencon.elearning.dto.examschedule.ExamScheduleDataDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleDeleteResDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleInsertDataResDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleInsertReqDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleInsertResDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleUpdateReqDto;
import com.lawencon.elearning.dto.examschedule.ExamScheduleUpdateResDto;
import com.lawencon.elearning.dto.examschedule.ExamSchedulesDto;
import com.lawencon.elearning.model.Classroom;
import com.lawencon.elearning.model.Exam;
import com.lawencon.elearning.model.ExamAttachment;
import com.lawencon.elearning.model.ExamSchedule;
import com.lawencon.elearning.model.File;
import com.lawencon.elearning.service.ExamScheduleService;
import com.lawencon.elearning.service.PrincipalService;

@Service
public class ExamScheduleServiceImpl implements ExamScheduleService {
	
	@Autowired
	private ExamScheduleDao examScheduleDao;
	@Autowired
	private ClassroomDao classroomDao;
	@Autowired
	private ExamDao examDao;
	@Autowired
	private ExamAttachmentDao examAttachmentDao;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private PrincipalService principalService;
	

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ExamScheduleInsertResDto insert(final ExamScheduleInsertReqDto data) {
		final ExamScheduleInsertResDto examScheduleRes = new ExamScheduleInsertResDto();
		final ExamScheduleInsertDataResDto dataRes = new ExamScheduleInsertDataResDto();
				
		final ExamSchedule examSchedule = new ExamSchedule();
		examSchedule.setStartTime(data.getStartTime());
		examSchedule.setEndTime(data.getEndTime());
		
		final Exam exam = new Exam(); 
		exam.setExamName(data.getExamName());
		exam.setExamCode(data.getExamCode());
		final Optional<Classroom> classroomOptional = classroomDao.getById(data.getClassroomid());
		exam.setClassroom(classroomOptional.get());
		exam.setCreatedBy(principalService.getPrincipal().getId());
		
		for (int i = 0; i < data.getExamAttachments().size(); i++) {
			final ExamAttachment examAttachment = new ExamAttachment();
			examAttachment.setCreatedBy(principalService.getPrincipal().getId());
			final File file = new File();
			file.setCreatedBy(principalService.getPrincipal().getId());
			file.setFiles(data.getExamAttachments().get(i).getFiles());
			file.setExtensions(data.getExamAttachments().get(i).getExtensions());
			fileDao.insert(file);
			examAttachment.setFile(file);
			examAttachmentDao.insert(examAttachment);
			exam.setExamAttachment(examAttachment);
		}
		examDao.insert(exam);
		examSchedule.setCreatedBy(principalService.getPrincipal().getId());
		examScheduleDao.insert(examSchedule);
		dataRes.setId(examSchedule.getId());
		examScheduleRes.setData(dataRes);
		examScheduleRes.setMessage(Message.INSERT.getMessageName());
		return examScheduleRes;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ExamScheduleUpdateResDto update(final ExamScheduleUpdateReqDto data) {
		return null;
	}

	@Override
	public ExamScheduleDto getById(final Long id) {
		final Optional<ExamSchedule> examScheduleOptional = examScheduleDao.getById(id);
		final ExamScheduleDataDto dataDto = new ExamScheduleDataDto();
		final ExamScheduleDto examScheduleDto = new ExamScheduleDto();
		if (examScheduleOptional.isPresent()) {
			dataDto.setId(id);
			dataDto.setExamName(examScheduleOptional.get().getExam().getExamName());
			dataDto.setExamCode(examScheduleOptional.get().getExam().getExamCode());
			dataDto.setStartTime(examScheduleOptional.get().getStartTime());
			dataDto.setEndTime(examScheduleOptional.get().getEndTime());
			dataDto.setTeacherName(examScheduleOptional.get().getExam().getClassroom().getTeacher().getFullName());
			dataDto.setClassroomName(examScheduleOptional.get().getExam().getClassroom().getClassroomName());
			dataDto.setExamAttachmentId(examScheduleOptional.get().getExam().getExamAttachment().getId());
			dataDto.setVersion(examScheduleOptional.get().getVersion());
			examScheduleDto.setData(dataDto);
		}
		return examScheduleDto;
	}

	@Override
	public ExamSchedulesDto getAll(final Long classId) {
		final List<ExamSchedule> examSchedules = examScheduleDao.getAll(principalService.getPrincipal().getId(), classId);
		final List<ExamScheduleDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < examSchedules.size(); i++) {
			final ExamSchedule examSchedule = examSchedules.get(i);
			final ExamScheduleDataDto dataDto = new ExamScheduleDataDto();
			dataDto.setId(examSchedule.getId());
			dataDto.setExamName(examSchedule.getExam().getExamName());
			dataDto.setExamCode(examSchedule.getExam().getExamCode());
			dataDto.setStartTime(examSchedule.getStartTime());
			dataDto.setEndTime(examSchedule.getEndTime());
			dataDto.setTeacherName(examSchedule.getExam().getClassroom().getTeacher().getFullName());
			dataDto.setClassroomName(examSchedule.getExam().getClassroom().getClassroomName());
			dataDto.setExamAttachmentId(examSchedule.getExam().getExamAttachment().getId());
			dataDto.setVersion(examSchedule.getVersion());
			dataDtos.add(dataDto);
		}
		final ExamSchedulesDto examSchedulesDto = new ExamSchedulesDto();
		examSchedulesDto.setData(dataDtos);

		return examSchedulesDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ExamScheduleDeleteResDto deleteById(final Long id) {
		return null;
	}
}
