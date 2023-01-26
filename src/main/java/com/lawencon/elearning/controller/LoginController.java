package com.lawencon.elearning.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dto.login.LoginReqDto;
import com.lawencon.elearning.dto.login.LoginResDto;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.service.JwtService;
import com.lawencon.elearning.service.UserService;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtService jwtService;
	
	
	@PostMapping
	public ResponseEntity<LoginResDto> login(@RequestBody final LoginReqDto data) {
		final Authentication auth = new UsernamePasswordAuthenticationToken(data.getUserEmail(), data.getUserPassword());
		authenticationManager.authenticate(auth);
		final Optional<User> user = userService.getByEmail(data.getUserEmail());		
		final Map<String, Object> claims = new HashMap<>();
		
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 1);
		claims.put("exp", cal.getTime());
		
		claims.put("id", user.get().getId());
		
		final LoginResDto loginResDto = new LoginResDto();
		loginResDto.setId(user.get().getId());
		loginResDto.setFullName(user.get().getFullName());
		loginResDto.setRoleCode(user.get().getRole().getRoleCode());
		loginResDto.setUserEmail(user.get().getUserEmail());
		loginResDto.setRoleName(user.get().getRole().getRoleName());
		loginResDto.setPhotoId(user.get().getPhoto().getId());
		loginResDto.setToken(jwtService.generateJwt(claims));
		
		return new ResponseEntity<LoginResDto>(loginResDto, HttpStatus.OK);
	}
	
}

