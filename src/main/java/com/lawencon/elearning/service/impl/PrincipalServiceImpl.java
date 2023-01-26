package com.lawencon.elearning.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.service.PrincipalService;


@Service
public class PrincipalServiceImpl implements PrincipalService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User getPrincipal() {
		final Long id = Long.valueOf(SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal().toString());
		final Optional<User> userOptional = userDao.getById(id);
		if (userOptional.isPresent()) {
			return userOptional.get(); 
		}
		throw new RuntimeException("invalid login");
	}

}
