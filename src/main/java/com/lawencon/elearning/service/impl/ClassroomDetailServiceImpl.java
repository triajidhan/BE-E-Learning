package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.constant.Message;
import com.lawencon.elearning.dao.ClassroomDao;
import com.lawencon.elearning.dao.ClassroomDetailDao;
import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailDataDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailInsertDataResDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailInsertReqDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailInsertResDto;
import com.lawencon.elearning.dto.classroomdetail.ClassroomDetailsDto;
import com.lawencon.elearning.model.Classroom;
import com.lawencon.elearning.model.ClassroomDetail;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.service.ClassroomDetailService;
import com.lawencon.elearning.service.PrincipalService;

@Service
public class ClassroomDetailServiceImpl implements ClassroomDetailService {

	@Autowired
	private ClassroomDetailDao classroomDetailDao;
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ClassroomDao classroomDao;
	
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public ClassroomDetailInsertResDto chooseClass(final ClassroomDetailInsertReqDto data) {
		final ClassroomDetailInsertResDto insertRes = new ClassroomDetailInsertResDto();
		final ClassroomDetailInsertDataResDto dataRes = new ClassroomDetailInsertDataResDto();

		final ClassroomDetail classroomDetail = new ClassroomDetail();
		final Optional<User> studentOptional = userDao.getById(principalService.getPrincipal().getId());
		classroomDetail.setStudent(studentOptional.get());
		final Optional<Classroom> classroomOptional = classroomDao.getById(data.getClassroomId());
		classroomDetail.setClassroom(classroomOptional.get());
		
		classroomDetail.setCreatedBy(principalService.getPrincipal().getId());
		final ClassroomDetail classroomDetailInsert = classroomDetailDao.insert(classroomDetail);	
		
		dataRes.setId(classroomDetailInsert.getId());
		insertRes.setData(dataRes);
		insertRes.setMessage(Message.INSERT.getMessageName());

		return insertRes;
	}

	@Override
	public ClassroomDetailDto getById(final Long id) {
		final Optional<ClassroomDetail> classroomDetailOptional = classroomDetailDao.getById(id);
		final ClassroomDetailDataDto dataDto = new ClassroomDetailDataDto();
		final ClassroomDetailDto assetDto = new ClassroomDetailDto();
		if (classroomDetailOptional.isPresent()) {
			dataDto.setId(id);
			dataDto.setClassId(classroomDetailOptional.get().getClassroom().getId());
			dataDto.setClassroomName(classroomDetailOptional.get().getClassroom().getClassroomName());
			dataDto.setClassroomCode(classroomDetailOptional.get().getClassroom().getClassroomCode());
			dataDto.setClassroomDescription(classroomDetailOptional.get().getClassroom().getClassroomDescription());
			dataDto.setPhotoId(classroomDetailOptional.get().getClassroom().getPhoto().getId());
			dataDto.setFullName(classroomDetailOptional.get().getClassroom().getTeacher().getFullName());
			dataDto.setVersion(classroomDetailOptional.get().getVersion());
			assetDto.setData(dataDto);
		}
		return assetDto;	
	}

	@Override
	public ClassroomDetailsDto getAll() {
		final List<ClassroomDetail> classroomDetails = classroomDetailDao.getAll(principalService.getPrincipal().getId());
		final List<ClassroomDetailDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < classroomDetails.size(); i++) {
			final ClassroomDetail classroomDetail = classroomDetails.get(i);
			final ClassroomDetailDataDto dataDto = new ClassroomDetailDataDto();
			dataDto.setId(classroomDetail.getId());
			dataDto.setClassId(classroomDetail.getClassroom().getId());
			dataDto.setClassroomName(classroomDetail.getClassroom().getClassroomName());
			dataDto.setClassroomCode(classroomDetail.getClassroom().getClassroomCode());
			dataDto.setClassroomDescription(classroomDetail.getClassroom().getClassroomDescription());
			dataDto.setPhotoId(classroomDetail.getClassroom().getPhoto().getId());
			dataDto.setFullName(classroomDetail.getClassroom().getTeacher().getFullName());
			dataDto.setVersion(classroomDetail.getVersion());
			dataDtos.add(dataDto);
		}
		final ClassroomDetailsDto classroomDetailsDto = new ClassroomDetailsDto();
		classroomDetailsDto.setData(dataDtos);

		return classroomDetailsDto;
	}
	
}
