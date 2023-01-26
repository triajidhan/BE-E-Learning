package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Optional;

import com.lawencon.elearning.model.ExamCollection;

public interface ExamCollectionDao {

	ExamCollection insert(ExamCollection data);

	ExamCollection update(ExamCollection data);

	Optional<ExamCollection> getById(Long id);

	List<ExamCollection> getAll(Long studentId, Long classId);
	
	List<ExamCollection> getAllStudent(Long teacherId, Long classId);

	boolean deleteById(Long id);
}
