package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.constant.Message;
import com.lawencon.elearning.constant.RoleType;
import com.lawencon.elearning.dao.FileDao;
import com.lawencon.elearning.dao.RoleDao;
import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.dto.user.UserDataDto;
import com.lawencon.elearning.dto.user.UserDeleteReqDto;
import com.lawencon.elearning.dto.user.UserDeleteResDto;
import com.lawencon.elearning.dto.user.UserDto;
import com.lawencon.elearning.dto.user.UserInsertDataResDto;
import com.lawencon.elearning.dto.user.UserInsertReqDto;
import com.lawencon.elearning.dto.user.UserInsertResDto;
import com.lawencon.elearning.dto.user.UserUpdateDataResDto;
import com.lawencon.elearning.dto.user.UserUpdateReqDto;
import com.lawencon.elearning.dto.user.UserUpdateResDto;
import com.lawencon.elearning.dto.user.UsersDto;
import com.lawencon.elearning.model.File;
import com.lawencon.elearning.model.Role;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.pojo.SendEmailPojo;
import com.lawencon.elearning.service.JavaMailService;
import com.lawencon.elearning.service.PrincipalService;
import com.lawencon.elearning.service.RandomTextService;
import com.lawencon.elearning.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private RandomTextService randomTextService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JavaMailService javaMailService;
	@Autowired
	private PrincipalService principalService;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public UserInsertResDto insertTeacher(final UserInsertReqDto data) {
		final UserInsertResDto userInserted = new UserInsertResDto();
		final UserInsertDataResDto userDataInserted = new UserInsertDataResDto();
				
		final User user = new User();
		user.setFullName(data.getFullName());
		user.setUserEmail(data.getUserEmail());
		
		final String planePass = randomTextService.getText();
		final String hash = passwordEncoder.encode(planePass);
		
		user.setUserPassword(hash);
		
		long getIdx = 0;
		for (int i = 0; i < roleDao.getAll().size(); i++) {
			final String roleCode = roleDao.getAll().get(i).getRoleCode();
			if (RoleType.TEACHER.getRoleCode().equalsIgnoreCase(roleCode));
				getIdx = i-1;
		}
		
		final Optional<Role> roleOptional = roleDao.getById(getIdx);
		user.setRole(roleOptional.get());
		
		final File photo = new File();
		photo.setFiles(data.getFiles());
		photo.setExtensions(data.getExtensions());
		photo.setCreatedBy(principalService.getPrincipal().getId());
		fileDao.insert(photo);
		user.setPhoto(photo);
		
		user.setCreatedBy(principalService.getPrincipal().getId());
		
		final User userInsert = userDao.insert(user);
		
		final SendEmailPojo emailPojo = new SendEmailPojo();
		emailPojo.setEmail(data.getUserEmail());
		emailPojo.setSubject("Registration Success");
		emailPojo.setBody("Congratulation, your registration is successful, \nyour password : " + planePass);
		
		javaMailService.sendEmail(emailPojo);
		
		userDataInserted.setId(userInsert.getId());
		userInserted.setData(userDataInserted);
		userInserted.setMessage(Message.INSERT.getMessageName());
		
		return userInserted;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public UserInsertResDto studentRegistration(final UserInsertReqDto data) {
		final UserInsertResDto userInserted = new UserInsertResDto();
		final UserInsertDataResDto userDataInserted = new UserInsertDataResDto();
				
		final User user = new User();
		user.setFullName(data.getFullName());
		user.setUserEmail(data.getUserEmail());
		
		final String planePass = randomTextService.getText();
		final String hash = passwordEncoder.encode(planePass);
		
		user.setUserPassword(hash);
		
		long getStdIdx = 0;
		for (int i = 0; i < roleDao.getAll().size(); i++) {
			final String roleCode = roleDao.getAll().get(i).getRoleCode();
			if (RoleType.STUDENT.getRoleCode().equalsIgnoreCase(roleCode));
				getStdIdx = i-2;
		}

		
		final Optional<Role> roleOptional = roleDao.getById(getStdIdx);
		user.setRole(roleOptional.get());
		
		final File photo = new File();
		photo.setFiles(data.getFiles());
		photo.setExtensions(data.getExtensions());
		photo.setCreatedBy(1l);
		fileDao.insert(photo);
		user.setPhoto(photo);
		
		user.setCreatedBy(1l);
		
		final User userInsert = userDao.insert(user);
		
		final SendEmailPojo emailPojo = new SendEmailPojo();
		emailPojo.setEmail(data.getUserEmail());
		emailPojo.setSubject("Registration Success");
		emailPojo.setBody("Congratulation, your registration is successful, \nyour password : " + planePass);
		
		javaMailService.sendEmail(emailPojo);
		
		userDataInserted.setId(userInsert.getId());
		userInserted.setData(userDataInserted);
		userInserted.setMessage(Message.INSERT.getMessageName());
		
		return userInserted;
	}

	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public UserUpdateResDto update(final UserUpdateReqDto data) {
		final Optional<User> userOptional = userDao.getById(data.getId());
		final UserUpdateResDto userUpdateResDto = new UserUpdateResDto();
		final UserUpdateDataResDto userUpdateDataResDto = new UserUpdateDataResDto();

		User userUpdated = null;
		if (userOptional.isPresent()) {
			userUpdated = userOptional.get();
			userUpdated.setFullName(userOptional.get().getFullName());
			
			final Long oldPhotoId = userDao.getById(data.getId()).get().getPhoto().getId();

			final File photo = new File();
			photo.setFiles(data.getFiles());
			photo.setExtensions(data.getExtensions());
			photo.setCreatedBy(principalService.getPrincipal().getId());
			fileDao.insert(photo);
			userUpdated.setPhoto(photo);

			userUpdated.setUpdatedBy(principalService.getPrincipal().getId());
			userUpdated.setIsActive(true);
			userUpdated.setId(data.getId());
			
			userUpdated = userDao.update(userUpdated);
			fileDao.deleteById(oldPhotoId);
			data.setVersion(userUpdated.getVersion());
			userUpdateDataResDto.setVersion(userUpdated.getVersion());
			userUpdateResDto.setData(userUpdateDataResDto);
			userUpdateResDto.setMessage(Message.UPDATE.getMessageName());
		}
		return userUpdateResDto;
	}

	@Override
	public UserDto getById(final Long id) {
		final Optional<User> userOptional = userDao.getById(id);
		final UserDataDto userDataDto = new UserDataDto();
		final UserDto userDto = new UserDto();
		if (userOptional.isPresent()) {
			userDataDto.setId(id);
			userDataDto.setFullName(userOptional.get().getFullName());
			userDataDto.setUserEmail(userOptional.get().getUserEmail());
			userDataDto.setRoleName(userOptional.get().getRole().getRoleName());
			userDataDto.setPhotoId(userOptional.get().getPhoto().getId());

			userDataDto.setVersion(userOptional.get().getVersion());

			userDto.setData(userDataDto);
		}
		return userDto;
	}

	@Override
	public UsersDto getAll(final String roleCode) {
		final List<User> users = userDao.getAll(roleCode);
		final List<UserDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < users.size(); i++) {
			final User user = users.get(i);
			final UserDataDto dataDto = new UserDataDto();
			dataDto.setId(user.getId());
			dataDto.setFullName(user.getFullName());
			dataDto.setUserEmail(user.getUserEmail());
			dataDto.setRoleName(user.getRole().getRoleName());
			dataDto.setPhotoId(user.getPhoto().getId());
			dataDto.setVersion(user.getVersion());
			dataDtos.add(dataDto);
		}
		final UsersDto usersDto = new UsersDto();
		usersDto.setData(dataDtos);

		return usersDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public UserDeleteResDto deleteById(final Long id) {
		final Optional<User> userOptional = userDao.getById(id);
		final UserDeleteResDto userDeleteResDto = new UserDeleteResDto();
		if (userOptional.isPresent()) {
			final UserDeleteReqDto userDeleteReqDto = new UserDeleteReqDto();
			userDeleteReqDto.setId(id);
			userDeleteResDto.setMessage(Message.DELETE.getMessageName());
			userDao.deleteById(id);
		}
		return userDeleteResDto;
	}


	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Optional<User> userOptional = userDao.getByEmail(username);
		if (userOptional.isPresent()) {
			return new org.springframework.security.core.userdetails
					.User(username, userOptional.get().getUserPassword(), 
					new ArrayList<>());
		}
		throw new  UsernameNotFoundException("Wrong Username or Password");
	}

	@Override
	public Optional<User> getByEmail(final String userEmail) {
		return userDao.getByEmail(userEmail);
	}
}
