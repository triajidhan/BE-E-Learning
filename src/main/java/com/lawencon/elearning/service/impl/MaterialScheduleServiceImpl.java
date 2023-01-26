package com.lawencon.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.MaterialScheduleDao;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleDataDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleDeleteResDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleInsertReqDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleInsertResDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleUpdateReqDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleUpdateResDto;
import com.lawencon.elearning.dto.materialschedule.MaterialSchedulesDto;
import com.lawencon.elearning.model.MaterialSchedule;
import com.lawencon.elearning.service.MaterialScheduleService;
import com.lawencon.elearning.service.PrincipalService;

@Service
public class MaterialScheduleServiceImpl implements MaterialScheduleService {

	@Autowired
	private MaterialScheduleDao materialScheduleDao;
	@Autowired
	private PrincipalService principalService;	
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public MaterialScheduleInsertResDto insert(final MaterialScheduleInsertReqDto data) {
		return null;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MaterialScheduleUpdateResDto update(final MaterialScheduleUpdateReqDto data) {
		return null;
	}

	@Override
	public MaterialScheduleDto getById(final Long id) {
		return null;
	}

	@Override
	public MaterialSchedulesDto getAll(final  Long classId) {
		final List<MaterialSchedule> materialSchedules = materialScheduleDao.getAll(principalService.getPrincipal().getId(), classId);
		final List<MaterialScheduleDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < materialSchedules.size(); i++) {
			final MaterialSchedule materialSchedule = materialSchedules.get(i);
			final MaterialScheduleDataDto dataDto = new MaterialScheduleDataDto();
			dataDto.setId(materialSchedule.getId());
			dataDto.setMaterialName(materialSchedule.getMaterial().getMaterialName());
			dataDto.setMaterialCode(materialSchedule.getMaterial().getMaterialCode());
			dataDto.setStartTime(materialSchedule.getStartTime());
			dataDto.setEndTime(materialSchedule.getEndTime());
			dataDto.setTeacherName(materialSchedule.getMaterial().getClassroom().getTeacher().getFullName());
			dataDto.setClassroomName(materialSchedule.getMaterial().getClassroom().getClassroomName());
			dataDto.setMaterialAttachmentId(materialSchedule.getMaterial().getMaterialAttachment().getId());
			dataDto.setVersion(materialSchedule.getVersion());
			dataDtos.add(dataDto);
		}
		final MaterialSchedulesDto materialSchedulesDto = new MaterialSchedulesDto();
		materialSchedulesDto.setData(dataDtos);

		return materialSchedulesDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MaterialScheduleDeleteResDto deleteById(final Long id) {
		return null;
	}


}
