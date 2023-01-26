package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.RoleDao;
import com.lawencon.elearning.dto.role.RoleDataDto;
import com.lawencon.elearning.dto.role.RoleDto;
import com.lawencon.elearning.dto.role.RolesDto;
import com.lawencon.elearning.model.Role;
import com.lawencon.elearning.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;


	@Override
	public RoleDto getById(final Long id) {
		final Optional<Role> roleOptional = roleDao.getById(id);
		final RoleDataDto roleDataDto = new RoleDataDto();
		final RoleDto roleDto = new RoleDto();
		if (roleOptional.isPresent()) {
			roleDataDto.setId(roleOptional.get().getId());
			roleDataDto.setRoleName(roleOptional.get().getRoleName());
			roleDataDto.setRoleCode(roleOptional.get().getRoleCode());
			roleDataDto.setVersion(roleOptional.get().getVersion());
			
			roleDto.setData(roleDataDto);
		}
		return roleDto;
	}

	@Override
	public RolesDto getAll() {
		final List<Role> roles = roleDao.getAll();
		final List<RoleDataDto> dataDtos = new ArrayList<>();
		
		for(int i = 0; i < roles.size(); i++) {
			final Role role = roles.get(i);
			final RoleDataDto dataDto = new RoleDataDto();
			dataDto.setId(role.getId());
			dataDto.setRoleName(role.getRoleName());
			dataDto.setRoleCode(role.getRoleCode());
			dataDto.setVersion(role.getVersion());
			dataDtos.add(dataDto);
		}
		final RolesDto rolesDto = new RolesDto();
		rolesDto.setData(dataDtos);
		
		return rolesDto;
	}
}
