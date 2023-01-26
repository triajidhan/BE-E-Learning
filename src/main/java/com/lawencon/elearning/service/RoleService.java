package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.role.RoleDto;
import com.lawencon.elearning.dto.role.RolesDto;

public interface RoleService {
	
	RoleDto getById(Long id);

	RolesDto getAll();

}
