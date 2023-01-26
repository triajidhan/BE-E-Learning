package com.lawencon.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.quizschedule.QuizSchedulesDto;
import com.lawencon.elearning.service.QuizScheduleService;

@RestController
@RequestMapping("quiz-schedules")
public class QuizScheduleController {

	
	@Autowired
	private QuizScheduleService quizScheduleService;
	
	@GetMapping
	public ResponseEntity<QuizSchedulesDto> getAll(@RequestParam(value = "class-id") final Long classId) {
		final QuizSchedulesDto quizSchedules = quizScheduleService.getAll(classId);
		return new ResponseEntity<>(quizSchedules, HttpStatus.OK);
	}
}
