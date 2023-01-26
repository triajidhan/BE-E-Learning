package com.lawencon.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.materialschedule.MaterialSchedulesDto;
import com.lawencon.elearning.service.MaterialScheduleService;

@RestController
@RequestMapping("material-schedules")
public class MaterialScheduleController {

	
	@Autowired
	private MaterialScheduleService materialScheduleService;
	
	@GetMapping
	public ResponseEntity<MaterialSchedulesDto> getAll(@RequestParam(value = "class-id") final Long classId) {
		final MaterialSchedulesDto materialSchedules = materialScheduleService.getAll(classId);
		return new ResponseEntity<>(materialSchedules, HttpStatus.OK);
	}
}
