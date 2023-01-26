package com.lawencon.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.role.RoleDto;
import com.lawencon.elearning.dto.role.RolesDto;
import com.lawencon.elearning.service.RoleService;

@RestController
@RequestMapping("roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<RolesDto> getAll() {
		final RolesDto roles = roleService.getAll();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<RoleDto> getById(@PathVariable("id") final Long id) {
		final RoleDto role = roleService.getById(id);
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
}
