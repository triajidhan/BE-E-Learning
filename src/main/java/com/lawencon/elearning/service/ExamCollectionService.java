package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.examcollection.ExamCollectionDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionUpdateReqDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionUpdateResDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionsDto;

public interface ExamCollectionService {
	
	ExamCollectionUpdateResDto sendExam(ExamCollectionUpdateReqDto data);

	ExamCollectionUpdateResDto assessment(ExamCollectionUpdateReqDto data);
	
	ExamCollectionDto getById(Long id);

	ExamCollectionsDto getAll(Long classId);
	
	ExamCollectionsDto getAllStudent(Long classId);

}
