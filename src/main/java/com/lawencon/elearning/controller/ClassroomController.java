package com.lawencon.elearning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.classroom.ClassroomDeleteResDto;
import com.lawencon.elearning.dto.classroom.ClassroomDto;
import com.lawencon.elearning.dto.classroom.ClassroomInsertReqDto;
import com.lawencon.elearning.dto.classroom.ClassroomInsertResDto;
import com.lawencon.elearning.dto.classroom.ClassroomUpdateReqDto;
import com.lawencon.elearning.dto.classroom.ClassroomUpdateResDto;
import com.lawencon.elearning.dto.classroom.ClassroomsDto;
import com.lawencon.elearning.service.ClassroomService;

@RestController
@RequestMapping("classrooms")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	@GetMapping
	public ResponseEntity<ClassroomsDto> getAll() {
		final ClassroomsDto classrooms = classroomService.getAll();
		return new ResponseEntity<>(classrooms, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ClassroomInsertResDto> insert(@Valid @RequestBody  final ClassroomInsertReqDto data) {
		final ClassroomInsertResDto insertRes = classroomService.insert(data);
		return new ResponseEntity<>(insertRes, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<ClassroomDto> getById(@PathVariable("id") final Long id) {
		final ClassroomDto classroom = classroomService.getById(id);
		return new ResponseEntity<>(classroom, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ClassroomUpdateResDto> update(@Valid @RequestBody  final ClassroomUpdateReqDto data) {
		final ClassroomUpdateResDto updateRes = classroomService.update(data);
		return new ResponseEntity<>(updateRes, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ClassroomDeleteResDto> delete(@PathVariable("id")  final Long id) {
		final ClassroomDeleteResDto deleteRes = classroomService.deleteById(id);
		return new ResponseEntity<>(deleteRes, HttpStatus.OK);
	}

}
