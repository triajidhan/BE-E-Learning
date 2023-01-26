package com.lawencon.elearning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.attendance.AttendanceDto;
import com.lawencon.elearning.dto.attendance.AttendanceInsertReqDto;
import com.lawencon.elearning.dto.attendance.AttendanceInsertResDto;
import com.lawencon.elearning.dto.attendance.AttendanceUpdateReqDto;
import com.lawencon.elearning.dto.attendance.AttendanceUpdateResDto;
import com.lawencon.elearning.dto.attendance.AttendancesDto;
import com.lawencon.elearning.service.AttendanceService;

@RestController
@RequestMapping("attendances")
public class AttendanceController {

	
	@Autowired
	private AttendanceService attendanceService;
	
	@GetMapping("materials")
	public ResponseEntity<AttendancesDto> getMaterial(@RequestParam(value = "id") final Long classId) {
		final AttendancesDto attendances = attendanceService.getMaterial(classId);
		return new ResponseEntity<>(attendances, HttpStatus.OK);
	}

	@GetMapping("quizzes")
	public ResponseEntity<AttendancesDto> getQuiz(@RequestParam(value = "id") final Long classId) {
		final AttendancesDto attendances = attendanceService.getQuiz(classId);
		return new ResponseEntity<>(attendances, HttpStatus.OK);
	}

	@GetMapping("exams")
	public ResponseEntity<AttendancesDto> getExam(@RequestParam(value = "id") final long classId) {
		final AttendancesDto attendances = attendanceService.getExam(classId);
		return new ResponseEntity<>(attendances, HttpStatus.OK);
	}
	
	@GetMapping("student-materials")
	public ResponseEntity<AttendancesDto> getMaterialStudent(@RequestParam(value = "id") final Long classId) {
		final AttendancesDto attendances = attendanceService.getMaterialStudent(classId);
		return new ResponseEntity<>(attendances, HttpStatus.OK);
	}

	@GetMapping("student-quizzes")
	public ResponseEntity<AttendancesDto> getQuizStudent(@RequestParam(value = "id") final Long classId) {
		final AttendancesDto attendances = attendanceService.getQuizStudent(classId);
		return new ResponseEntity<>(attendances, HttpStatus.OK);
	}

	@GetMapping("student-exams")
	public ResponseEntity<AttendancesDto> getExamStudent(@RequestParam(value = "id") final Long classId) {
		final AttendancesDto attendances = attendanceService.getExamStudent(classId);
		return new ResponseEntity<>(attendances, HttpStatus.OK);
	}

	
	@PostMapping
	public ResponseEntity<AttendanceInsertResDto> studentAttend(@Valid @RequestBody final AttendanceInsertReqDto data) {
		final AttendanceInsertResDto insertRes = attendanceService.studentAttend(data);
		return new ResponseEntity<>(insertRes, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<AttendanceDto> getById(@PathVariable("id") final Long id) {
		final AttendanceDto data = attendanceService.getById(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<AttendanceUpdateResDto> approveAttend(@Valid @RequestBody final AttendanceUpdateReqDto data) {
		final AttendanceUpdateResDto updateRes = attendanceService.approveAttend(data);
		return new ResponseEntity<>(updateRes, HttpStatus.OK);
	}
	
}
