package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Optional;

import com.lawencon.elearning.model.Attendance;

public interface AttendanceDao {

	Attendance insert(Attendance data);

	Attendance update(Attendance data);

	Optional<Attendance> getById(Long id);

	List<Attendance> getMaterial(Long teacherId, boolean approve, Long classId);
	
	List<Attendance> getQuiz(Long teacherId, boolean approve, Long classId);
	
	List<Attendance> getExam(Long teacherId, boolean approve, Long classId);
	
	List<Attendance> getMaterialStudent(Long studentId, boolean approve, Long classId);
	
	List<Attendance> getQuizStudent(Long studentId, boolean approve, Long classId);
	
	List<Attendance> getExamStudent(Long studentId, boolean approve, Long classId);
	
	boolean deleteById(Long id);

}
