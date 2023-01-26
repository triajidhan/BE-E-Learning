package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Optional;

import com.lawencon.elearning.model.User;

public interface UserDao  {
	
	User insert(User data);

	User update(User data);

	Optional<User> getById(Long id);

	List<User> getAll(String roleCode);

	boolean deleteById(Long id);
	
	Optional<User> getByEmail(String userEmail);
}
