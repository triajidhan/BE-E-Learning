package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.quizcollection.QuizCollectionDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionUpdateReqDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionUpdateResDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionsDto;

public interface QuizCollectionService {

	QuizCollectionUpdateResDto sendQuiz(QuizCollectionUpdateReqDto data);
	
	QuizCollectionUpdateResDto assessment(QuizCollectionUpdateReqDto data);

	QuizCollectionDto getById(Long id);

	QuizCollectionsDto getAll(Long classId);
	
	QuizCollectionsDto getAllStudent(Long classId);
}
