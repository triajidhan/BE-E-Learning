package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.constant.Message;
import com.lawencon.elearning.dao.FileDao;
import com.lawencon.elearning.dao.QuizCollectionDao;
import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionDataDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionUpdateDataResDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionUpdateReqDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionUpdateResDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionsDto;
import com.lawencon.elearning.model.File;
import com.lawencon.elearning.model.QuizCollection;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.service.PrincipalService;
import com.lawencon.elearning.service.QuizCollectionService;

@Service
public class QuizCollectionServiceImpl implements QuizCollectionService {

	@Autowired
	private QuizCollectionDao quizCollectionDao;
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private FileDao fileDao;	
	@Autowired
	private UserDao userDao;



	@Override
	@Transactional(rollbackOn = Exception.class)
	public QuizCollectionUpdateResDto sendQuiz(final QuizCollectionUpdateReqDto data) {
		final Optional<QuizCollection> quizCollectionOptional = quizCollectionDao.getById(data.getId());
		final QuizCollectionUpdateResDto updateRes = new QuizCollectionUpdateResDto();
		final QuizCollectionUpdateDataResDto dataRes = new QuizCollectionUpdateDataResDto();

		QuizCollection quizCollectionUpdate = null;
		if (quizCollectionOptional.isPresent()) {
			quizCollectionUpdate = quizCollectionOptional.get();
			final File file = new File();
			file.setFiles(data.getFiles());
			file.setExtensions(data.getExtensions());
			file.setCreatedBy(principalService.getPrincipal().getId());
			fileDao.insert(file);
			quizCollectionUpdate.setFile(file);

			quizCollectionUpdate.setUpdatedBy(principalService.getPrincipal().getId());
			quizCollectionUpdate.setIsActive(true);
			quizCollectionUpdate.setId(data.getId());
			
			quizCollectionUpdate = quizCollectionDao.update(quizCollectionUpdate);
			dataRes.setVersion(quizCollectionUpdate.getVersion());
			updateRes.setData(dataRes);
			updateRes.setMessage(Message.UPDATE.getMessageName());
		}
		return updateRes;	
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public QuizCollectionUpdateResDto assessment(final QuizCollectionUpdateReqDto data) {
		final Optional<QuizCollection> quizCollectionOptional = quizCollectionDao.getById(data.getId());
		final QuizCollectionUpdateResDto updateRes = new QuizCollectionUpdateResDto();
		final QuizCollectionUpdateDataResDto dataRes = new QuizCollectionUpdateDataResDto();

		QuizCollection quizCollectionUpdate = null;
		if (quizCollectionOptional.isPresent()) {
			quizCollectionUpdate = quizCollectionOptional.get();
			quizCollectionUpdate.setScore(data.getScore());
			quizCollectionUpdate.setUpdatedBy(principalService.getPrincipal().getId());
			quizCollectionUpdate.setIsActive(true);
			quizCollectionUpdate.setId(data.getId());
			
			quizCollectionUpdate = quizCollectionDao.update(quizCollectionUpdate);
			dataRes.setVersion(quizCollectionUpdate.getVersion());
			updateRes.setData(dataRes);
			updateRes.setMessage(Message.UPDATE.getMessageName());
		}
		return updateRes;	
	}

	@Override
	public QuizCollectionDto getById(final Long id) {
		final Optional<QuizCollection> quizCollectionOptional = quizCollectionDao.getById(id);
		final QuizCollectionDataDto dataDto = new QuizCollectionDataDto();
		final QuizCollectionDto quizCollectionDto = new QuizCollectionDto();
		if (quizCollectionOptional.isPresent()) {
			dataDto.setId(id);
			final Optional<User> studentOptional = userDao.getById(quizCollectionOptional.get().getCreatedBy());
			dataDto.setStudentName(studentOptional.get().getFullName());
			dataDto.setQuizName(quizCollectionOptional.get().getQuizSchedule().getQuiz().getQuizName());
			if (quizCollectionOptional.get().getFile() != null) {
				dataDto.setFileId(quizCollectionOptional.get().getFile().getId());				
			}
			dataDto.setScore(quizCollectionOptional.get().getScore());
			dataDto.setVersion(quizCollectionOptional.get().getVersion());
			quizCollectionDto.setData(dataDto);
		}
		return quizCollectionDto;	
	}

	@Override
	public QuizCollectionsDto getAll(final Long classId) {
		final List<QuizCollection> quizCollections = quizCollectionDao.getAll(principalService.getPrincipal().getId(), classId);
		final List<QuizCollectionDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < quizCollections.size(); i++) {
			final QuizCollection quizCollection = quizCollections.get(i);
			final QuizCollectionDataDto dataDto = new QuizCollectionDataDto();
			dataDto.setId(quizCollection.getId());
			final Optional<User> studentOptional = userDao.getById(quizCollection.getCreatedBy());
			dataDto.setStudentName(studentOptional.get().getFullName());
			dataDto.setQuizName(quizCollection.getQuizSchedule().getQuiz().getQuizName());
			if (quizCollection.getFile() != null) {
				dataDto.setFileId(quizCollection.getFile().getId());
			}
			dataDto.setScore(quizCollection.getScore());
			dataDto.setVersion(quizCollection.getVersion());
			dataDtos.add(dataDto);
		}
		final QuizCollectionsDto quizCollectionsDto = new QuizCollectionsDto();
		quizCollectionsDto.setData(dataDtos);

		return quizCollectionsDto;
	}
	
	@Override
	public QuizCollectionsDto getAllStudent(final Long classId) {
		final List<QuizCollection> quizCollections = quizCollectionDao.getAllStudent(principalService.getPrincipal().getId(), classId);
		final List<QuizCollectionDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < quizCollections.size(); i++) {
			final QuizCollection quizCollection = quizCollections.get(i);
			final QuizCollectionDataDto dataDto = new QuizCollectionDataDto();
			dataDto.setId(quizCollection.getId());
			final Optional<User> studentOptional = userDao.getById(quizCollection.getCreatedBy());
			dataDto.setStudentName(studentOptional.get().getFullName());
			dataDto.setQuizName(quizCollection.getQuizSchedule().getQuiz().getQuizName());
			if (quizCollection.getFile() != null) {
				dataDto.setFileId(quizCollection.getFile().getId());				
			}
			dataDto.setScore(quizCollection.getScore());
			dataDto.setVersion(quizCollection.getVersion());
			dataDtos.add(dataDto);
		}
		final QuizCollectionsDto quizCollectionsDto = new QuizCollectionsDto();
		quizCollectionsDto.setData(dataDtos);

		return quizCollectionsDto;

	}

}