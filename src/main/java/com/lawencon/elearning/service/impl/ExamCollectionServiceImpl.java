package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.constant.Message;
import com.lawencon.elearning.dao.ExamCollectionDao;
import com.lawencon.elearning.dao.FileDao;
import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.dto.examcollection.ExamCollectionDataDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionUpdateDataResDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionUpdateReqDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionUpdateResDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionsDto;
import com.lawencon.elearning.model.ExamCollection;
import com.lawencon.elearning.model.File;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.service.ExamCollectionService;
import com.lawencon.elearning.service.PrincipalService;

@Service
public class ExamCollectionServiceImpl implements ExamCollectionService {

	@Autowired
	private ExamCollectionDao examCollectionDao;
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private FileDao fileDao;	
	@Autowired
	private UserDao userDao;



	@Override
	@Transactional(rollbackOn = Exception.class)
	public ExamCollectionUpdateResDto sendExam(final ExamCollectionUpdateReqDto data) {
		final Optional<ExamCollection> examCollectionOptional = examCollectionDao.getById(data.getId());
		final ExamCollectionUpdateResDto updateRes = new ExamCollectionUpdateResDto();
		final ExamCollectionUpdateDataResDto dataRes = new ExamCollectionUpdateDataResDto();

		ExamCollection examCollectionUpdate = null;
		if (examCollectionOptional.isPresent()) {
			examCollectionUpdate = examCollectionOptional.get();
			final File file = new File();
			file.setFiles(data.getFiles());
			file.setExtensions(data.getExtensions());
			file.setCreatedBy(principalService.getPrincipal().getId());
			fileDao.insert(file);
			examCollectionUpdate.setFile(file);

			examCollectionUpdate.setUpdatedBy(principalService.getPrincipal().getId());
			examCollectionUpdate.setIsActive(true);
			examCollectionUpdate.setId(data.getId());
			
			examCollectionUpdate = examCollectionDao.update(examCollectionUpdate);
			dataRes.setVersion(examCollectionUpdate.getVersion());
			updateRes.setData(dataRes);
			updateRes.setMessage(Message.UPDATE.getMessageName());
		}
		return updateRes;	
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ExamCollectionUpdateResDto assessment(final ExamCollectionUpdateReqDto data) {
		final Optional<ExamCollection> examCollectionOptional = examCollectionDao.getById(data.getId());
		final ExamCollectionUpdateResDto updateRes = new ExamCollectionUpdateResDto();
		final ExamCollectionUpdateDataResDto dataRes = new ExamCollectionUpdateDataResDto();

		ExamCollection examCollectionUpdate = null;
		if (examCollectionOptional.isPresent()) {
			examCollectionUpdate = examCollectionOptional.get();
			examCollectionUpdate.setScore(data.getScore());
			examCollectionUpdate.setUpdatedBy(principalService.getPrincipal().getId());
			examCollectionUpdate.setIsActive(true);
			examCollectionUpdate.setId(data.getId());
			
			examCollectionUpdate = examCollectionDao.update(examCollectionUpdate);
			dataRes.setVersion(examCollectionUpdate.getVersion());
			updateRes.setData(dataRes);
			updateRes.setMessage(Message.UPDATE.getMessageName());
		}
		return updateRes;	
	}

	@Override
	public ExamCollectionDto getById(final Long id) {
		final Optional<ExamCollection> examCollectionOptional = examCollectionDao.getById(id);
		final ExamCollectionDataDto dataDto = new ExamCollectionDataDto();
		final ExamCollectionDto examCollectionDto = new ExamCollectionDto();
		if (examCollectionOptional.isPresent()) {
			dataDto.setId(id);
			final Optional<User> studentOptional = userDao.getById(examCollectionOptional.get().getCreatedBy());
			dataDto.setStudentName(studentOptional.get().getFullName());
			dataDto.setExamName(examCollectionOptional.get().getExamSchedule().getExam().getExamName());
			if (examCollectionOptional.get().getFile() != null) {
				dataDto.setFileId(examCollectionOptional.get().getFile().getId());				
			}
			dataDto.setScore(examCollectionOptional.get().getScore());
			dataDto.setVersion(examCollectionOptional.get().getVersion());
			examCollectionDto.setData(dataDto);
		}
		return examCollectionDto;	
	}

	@Override
	public ExamCollectionsDto getAll(final Long classId) {
		final List<ExamCollection> examCollections = examCollectionDao.getAll(principalService.getPrincipal().getId(), classId);
		final List<ExamCollectionDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < examCollections.size(); i++) {
			final ExamCollection examCollection = examCollections.get(i);
			final ExamCollectionDataDto dataDto = new ExamCollectionDataDto();
			dataDto.setId(examCollection.getId());
			final Optional<User> studentOptional = userDao.getById(examCollection.getCreatedBy());
			dataDto.setStudentName(studentOptional.get().getFullName());
			dataDto.setExamName(examCollection.getExamSchedule().getExam().getExamName());
			if (examCollection.getFile() != null) {
				dataDto.setFileId(examCollection.getFile().getId());				
			}
			dataDto.setClassroomName(examCollection.getExamSchedule().getExam().getClassroom().getClassroomName());
			dataDto.setTeacherName(examCollection.getExamSchedule().getExam().getClassroom().getTeacher().getFullName());
			dataDto.setScore(examCollection.getScore());
			dataDto.setVersion(examCollection.getVersion());
			dataDtos.add(dataDto);
		}
		final ExamCollectionsDto examCollectionsDto = new ExamCollectionsDto();
		examCollectionsDto.setData(dataDtos);

		return examCollectionsDto;
	}
	
	@Override
	public ExamCollectionsDto getAllStudent(final Long classId) {
		final List<ExamCollection> examCollections = examCollectionDao.getAllStudent(principalService.getPrincipal().getId(), classId);
		final List<ExamCollectionDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < examCollections.size(); i++) {
			final ExamCollection examCollection = examCollections.get(i);
			final ExamCollectionDataDto dataDto = new ExamCollectionDataDto();
			dataDto.setId(examCollection.getId());
			final Optional<User> studentOptional = userDao.getById(examCollection.getCreatedBy());
			dataDto.setStudentName(studentOptional.get().getFullName());
			dataDto.setExamName(examCollection.getExamSchedule().getExam().getExamName());
			if (examCollection.getFile() != null) {
				dataDto.setFileId(examCollection.getFile().getId());				
			}
			dataDto.setScore(examCollection.getScore());
			dataDto.setVersion(examCollection.getVersion());
			dataDtos.add(dataDto);
		}
		final ExamCollectionsDto examCollectionsDto = new ExamCollectionsDto();
		examCollectionsDto.setData(dataDtos);

		return examCollectionsDto;

	}

}
