package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Optional;

import com.lawencon.elearning.model.ClassroomDetail;

public interface ClassroomDetailDao {

	ClassroomDetail insert(ClassroomDetail data);

	ClassroomDetail update(ClassroomDetail data);

	Optional<ClassroomDetail> getById(Long id);

	List<ClassroomDetail> getAll(Long studentId);

	boolean deleteById(Long id);

}
