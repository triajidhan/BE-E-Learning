package com.lawencon.elearning.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lawencon.elearning.dto.user.UserDeleteResDto;
import com.lawencon.elearning.dto.user.UserDto;
import com.lawencon.elearning.dto.user.UserInsertReqDto;
import com.lawencon.elearning.dto.user.UserInsertResDto;
import com.lawencon.elearning.dto.user.UserUpdateReqDto;
import com.lawencon.elearning.dto.user.UserUpdateResDto;
import com.lawencon.elearning.dto.user.UsersDto;
import com.lawencon.elearning.model.User;



public interface UserService extends UserDetailsService {
	
	UserInsertResDto insertTeacher(UserInsertReqDto data);
	
	UserInsertResDto studentRegistration(UserInsertReqDto data);

	UserUpdateResDto update(UserUpdateReqDto data);

	UserDto getById(Long id);

	UsersDto getAll(String roleCode);

	UserDeleteResDto deleteById(Long id);

	
	Optional<User> getByEmail(String userEmail);
}
