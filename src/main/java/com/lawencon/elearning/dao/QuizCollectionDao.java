package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Optional;

import com.lawencon.elearning.model.QuizCollection;

public interface QuizCollectionDao {

	QuizCollection insert(QuizCollection data);

	QuizCollection update(QuizCollection data);

	Optional<QuizCollection> getById(Long id);

	List<QuizCollection> getAll(Long studentId, Long classId);

	List<QuizCollection> getAllStudent(Long teacherId, Long classId);

	boolean deleteById(Long id);
}
