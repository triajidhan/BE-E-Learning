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

import com.lawencon.elearning.dto.quizcollection.QuizCollectionDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionUpdateReqDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionUpdateResDto;
import com.lawencon.elearning.dto.quizcollection.QuizCollectionsDto;
import com.lawencon.elearning.service.QuizCollectionService;

@RestController
@RequestMapping("quiz-collections")
public class QuizCollectionController {

	@Autowired
	private QuizCollectionService quizCollectionService;

	@GetMapping
	public ResponseEntity<QuizCollectionsDto> getAll(@RequestParam(value = "id") final Long classId) {
		final QuizCollectionsDto quizCollections = quizCollectionService.getAll(classId);
		return new ResponseEntity<>(quizCollections, HttpStatus.OK);
	}

	@GetMapping("students")
	public ResponseEntity<QuizCollectionsDto> getAllStudent(@RequestParam(value = "id") final Long classId) {
		final QuizCollectionsDto quizCollections = quizCollectionService.getAllStudent(classId);
		return new ResponseEntity<>(quizCollections, HttpStatus.OK);
	}


	@GetMapping("{id}")
	public ResponseEntity<QuizCollectionDto> getById(@PathVariable("id") final Long id) {
		final QuizCollectionDto quizCollection = quizCollectionService.getById(id);
		return new ResponseEntity<>(quizCollection, HttpStatus.OK);
	}

	@PutMapping("send-quizzes")
	public ResponseEntity<QuizCollectionUpdateResDto> sendQuiz(@Valid @RequestBody  final QuizCollectionUpdateReqDto data) {
		final QuizCollectionUpdateResDto updateRes = quizCollectionService.sendQuiz(data);
		return new ResponseEntity<>(updateRes, HttpStatus.OK);
	}

	@PutMapping("assessments")
	public ResponseEntity<QuizCollectionUpdateResDto> assessment(@Valid @RequestBody  final QuizCollectionUpdateReqDto data) {
		final QuizCollectionUpdateResDto updateRes = quizCollectionService.assessment(data);
		return new ResponseEntity<>(updateRes, HttpStatus.OK);
	}

}
