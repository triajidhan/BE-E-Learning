package com.lawencon.elearning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.examcollection.ExamCollectionDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionUpdateReqDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionUpdateResDto;
import com.lawencon.elearning.dto.examcollection.ExamCollectionsDto;
import com.lawencon.elearning.service.ExamCollectionService;

@RestController
@RequestMapping("exam-collections")
public class ExamCollectionController {


	@Autowired
	private ExamCollectionService examCollectionService;

	@GetMapping
	public ResponseEntity<ExamCollectionsDto> getAll(@RequestParam(value = "id") final Long classId) {
		final ExamCollectionsDto examCollections = examCollectionService.getAll(classId);
		return new ResponseEntity<>(examCollections, HttpStatus.OK);
	}

	@GetMapping("students")
	public ResponseEntity<ExamCollectionsDto> getAllStudent(@RequestParam(value = "id") final Long classId) {
		final ExamCollectionsDto examCollections = examCollectionService.getAllStudent(classId);
		return new ResponseEntity<>(examCollections, HttpStatus.OK);
	}


	@GetMapping("{id}")
	public ResponseEntity<ExamCollectionDto> getById(@PathVariable("id") final Long id) {
		final ExamCollectionDto examCollection = examCollectionService.getById(id);
		return new ResponseEntity<>(examCollection, HttpStatus.OK);
	}

	@PutMapping("send-exams")
	public ResponseEntity<ExamCollectionUpdateResDto> sendExam(@Valid @RequestBody  final ExamCollectionUpdateReqDto data) {
		final ExamCollectionUpdateResDto updateRes = examCollectionService.sendExam(data);
		return new ResponseEntity<>(updateRes, HttpStatus.OK);
	}

	@PutMapping("assessments")
	public ResponseEntity<ExamCollectionUpdateResDto> assessment(@Valid @RequestBody  final ExamCollectionUpdateReqDto data) {
		final ExamCollectionUpdateResDto updateRes = examCollectionService.assessment(data);
		return new ResponseEntity<>(updateRes, HttpStatus.OK);
	}

}
