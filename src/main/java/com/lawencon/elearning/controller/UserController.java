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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.user.UserDeleteResDto;
import com.lawencon.elearning.dto.user.UserDto;
import com.lawencon.elearning.dto.user.UserInsertReqDto;
import com.lawencon.elearning.dto.user.UserInsertResDto;
import com.lawencon.elearning.dto.user.UserUpdateReqDto;
import com.lawencon.elearning.dto.user.UserUpdateResDto;
import com.lawencon.elearning.dto.user.UsersDto;
import com.lawencon.elearning.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<UsersDto> getAll(@RequestParam(value = "role-code") final String roleCode) {
		final UsersDto users = userService.getAll(roleCode);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("teachers")
	public ResponseEntity<UserInsertResDto> insertTeacher(@Valid @RequestBody final UserInsertReqDto data) {
		final UserInsertResDto userInsertResDto = userService.insertTeacher(data);
		return new ResponseEntity<>(userInsertResDto, HttpStatus.CREATED);
	}
	
	@PostMapping("registrations")
	public ResponseEntity<UserInsertResDto> studentRegistration(@Valid @RequestBody final UserInsertReqDto data) {
		final UserInsertResDto userInsertResDto = userService.studentRegistration(data);
		return new ResponseEntity<>(userInsertResDto, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> getById(@PathVariable("id") final Long id) {
		final UserDto user = userService.getById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UserUpdateResDto> update(@Valid @RequestBody final UserUpdateReqDto data) {
		final UserUpdateResDto updateUser = userService.update(data);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<UserDeleteResDto> delete(@Valid @PathVariable("id") final Long id) {
		final UserDeleteResDto deleteUser = userService.deleteById(id);
		return new ResponseEntity<>(deleteUser, HttpStatus.OK);
	}

}

