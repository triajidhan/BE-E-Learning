package com.lawencon.elearning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailInsertReqDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailInsertResDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailsDto;
import com.lawencon.elearning.service.ClassroomDetailService;

@RestController
@RequestMapping("classroom-details")
public class ClassroomDetailController {

	@Autowired
	private ClassroomDetailService classroomDetailService;

	@GetMapping
	public ResponseEntity<ClassroomDetailsDto> getAll() {
		final ClassroomDetailsDto classroomDetails = classroomDetailService.getAll();
		return new ResponseEntity<>(classroomDetails, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ClassroomDetailInsertResDto> insert(@Valid @RequestBody  final ClassroomDetailInsertReqDto data) {
		final ClassroomDetailInsertResDto insertRes = classroomDetailService.chooseClass(data);
		return new ResponseEntity<>(insertRes, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<ClassroomDetailDto> getById(@PathVariable("id") final Long id) {
		final ClassroomDetailDto classroomDetail = classroomDetailService.getById(id);
		return new ResponseEntity<>(classroomDetail, HttpStatus.OK);
	}

}
