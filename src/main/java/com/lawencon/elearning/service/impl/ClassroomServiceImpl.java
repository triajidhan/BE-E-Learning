package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.constant.Message;
import com.lawencon.elearning.dao.ClassroomDao;
import com.lawencon.elearning.dao.FileDao;
import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.dto.classroom.ClassroomDataDto;
import com.lawencon.elearning.dto.classroom.ClassroomDeleteReqDto;
import com.lawencon.elearning.dto.classroom.ClassroomDeleteResDto;
import com.lawencon.elearning.dto.classroom.ClassroomDto;
import com.lawencon.elearning.dto.classroom.ClassroomInsertDataResDto;
import com.lawencon.elearning.dto.classroom.ClassroomInsertReqDto;
import com.lawencon.elearning.dto.classroom.ClassroomInsertResDto;
import com.lawencon.elearning.dto.classroom.ClassroomUpdateDataResDto;
import com.lawencon.elearning.dto.classroom.ClassroomUpdateReqDto;
import com.lawencon.elearning.dto.classroom.ClassroomUpdateResDto;
import com.lawencon.elearning.dto.classroom.ClassroomsDto;
import com.lawencon.elearning.model.Classroom;
import com.lawencon.elearning.model.File;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.service.ClassroomService;
import com.lawencon.elearning.service.PrincipalService;

@Service
public class ClassroomServiceImpl implements ClassroomService {

	@Autowired
	private ClassroomDao classroomDao;
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private FileDao fileDao;


	@Override
	@Transactional(rollbackOn = Exception.class)
	public ClassroomInsertResDto insert(final ClassroomInsertReqDto data) {
		final ClassroomInsertResDto insertRes = new ClassroomInsertResDto();
		final ClassroomInsertDataResDto dataRes = new ClassroomInsertDataResDto();

		final Classroom classroom = new Classroom();
		classroom.setClassroomName(data.getClassroomName());
		classroom.setClassroomCode(data.getClassroomCode());
		classroom.setClassroomDescription(data.getClassroomDescription());
		
		final Optional<User> teacherOptional = userDao.getById(data.getTeacherId());
		classroom.setTeacher(teacherOptional.get());

		final File photo = new File();
		photo.setFiles(data.getFiles());
		photo.setExtensions(data.getExtensions());
		photo.setCreatedBy(principalService.getPrincipal().getId());
		fileDao.insert(photo);
		classroom.setPhoto(photo);
		
		classroom.setCreatedBy(principalService.getPrincipal().getId());
		final Classroom classroomInsert = classroomDao.insert(classroom);	
		
		dataRes.setId(classroomInsert.getId());
		insertRes.setData(dataRes);
		insertRes.setMessage(Message.INSERT.getMessageName());

		return insertRes;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ClassroomUpdateResDto update(final ClassroomUpdateReqDto data) {
		final Optional<Classroom> classroomOptional = classroomDao.getById(data.getId());
		final ClassroomUpdateResDto updateRes = new ClassroomUpdateResDto();
		final ClassroomUpdateDataResDto dataRes = new ClassroomUpdateDataResDto();

		Classroom classroomUpdate = null;
		if (classroomOptional.isPresent()) {
			classroomUpdate = classroomOptional.get();
			classroomUpdate.setClassroomName(data.getClassroomName());
			classroomUpdate.setClassroomDescription(data.getClassroomDescription());
			
			final Optional<User> teacherOptional = userDao.getById(data.getTeacherId());
			classroomUpdate.setTeacher(teacherOptional.get());

			final Long oldPhotoId = classroomDao.getById(data.getId()).get().getPhoto().getId();
			
			final File photo = new File();
			photo.setFiles(data.getFiles());
			photo.setExtensions(data.getExtensions());
			photo.setCreatedBy(principalService.getPrincipal().getId());
			fileDao.insert(photo);
			classroomUpdate.setPhoto(photo);

			classroomUpdate.setUpdatedBy(principalService.getPrincipal().getId());
			classroomUpdate.setIsActive(true);
			classroomUpdate.setId(data.getId());
			
			classroomUpdate = classroomDao.update(classroomUpdate);
			fileDao.deleteById(oldPhotoId);
			dataRes.setVersion(classroomUpdate.getVersion());
			updateRes.setData(dataRes);
			updateRes.setMessage(Message.UPDATE.getMessageName());
		}
		return updateRes;	
	}

	@Override
	public ClassroomDto getById(final Long id) {
		final Optional<Classroom> classroomOptional = classroomDao.getById(id);
		final ClassroomDataDto dataDto = new ClassroomDataDto();
		final ClassroomDto classroomDto = new ClassroomDto();
		if (classroomOptional.isPresent()) {
			dataDto.setId(id);
			dataDto.setClassroomName(classroomOptional.get().getClassroomName());
			dataDto.setClassroomCode(classroomOptional.get().getClassroomCode());
			dataDto.setClassroomDescription(classroomOptional.get().getClassroomDescription());
			dataDto.setFullName(classroomOptional.get().getTeacher().getFullName());
			dataDto.setPhotoId(classroomOptional.get().getPhoto().getId());
			dataDto.setVersion(classroomOptional.get().getVersion());
			classroomDto.setData(dataDto);
		}
		return classroomDto;	
	}

	@Override
	public ClassroomsDto getAll() {
		final List<Classroom> classrooms = classroomDao.getAll();
		final List<ClassroomDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < classrooms.size(); i++) {
			final Classroom classroom = classrooms.get(i);
			final ClassroomDataDto dataDto = new ClassroomDataDto();
			dataDto.setId(classroom.getId());
			dataDto.setClassroomName(classroom.getClassroomName());
			dataDto.setClassroomCode(classroom.getClassroomCode());
			dataDto.setClassroomDescription(classroom.getClassroomDescription());
			dataDto.setFullName(classroom.getTeacher().getFullName());
			dataDto.setPhotoId(classroom.getPhoto().getId());
			dataDto.setVersion(classroom.getVersion());
			dataDtos.add(dataDto);
		}
		final ClassroomsDto classroomsDto = new ClassroomsDto();
		classroomsDto.setData(dataDtos);

		return classroomsDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ClassroomDeleteResDto deleteById(final Long id) {
		final Optional<Classroom> classroomOptional = classroomDao.getById(id);
		final ClassroomDeleteResDto deleteRes = new ClassroomDeleteResDto();
		if (classroomOptional.isPresent()) {
			final ClassroomDeleteReqDto data = new ClassroomDeleteReqDto();
			data.setId(id);
			deleteRes.setMessage(Message.DELETE.getMessageName());
			classroomDao.deleteById(id);
		}
		return deleteRes;
	}
	
}