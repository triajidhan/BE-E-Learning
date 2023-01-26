package com.lawencon.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.examschedule.ExamSchedulesDto;
import com.lawencon.elearning.service.ExamScheduleService;

@RestController
@RequestMapping("exam-schedules")
public class ExamScheduleController {

	@Autowired
	private ExamScheduleService examScheduleService;
	
	@GetMapping
	public ResponseEntity<ExamSchedulesDto> getAll(@RequestParam(value = "class-id") final Long classId) {
		final ExamSchedulesDto examSchedules = examScheduleService.getAll(classId);
		return new ResponseEntity<>(examSchedules, HttpStatus.OK);
	}
}
