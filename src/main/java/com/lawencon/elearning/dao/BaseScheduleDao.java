package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Optional;

public interface BaseScheduleDao<T> {

	T insert(T data);

	T update(T data);

	Optional<T> getById(Long id);

	List<T> getAll(Long studentId, Long classId);

	boolean deleteById(Long id);

}
