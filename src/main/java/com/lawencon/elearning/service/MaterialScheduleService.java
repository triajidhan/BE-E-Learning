package com.lawencon.elearning.service;

import com.lawencon.elearning.dto.materialschedule.MaterialScheduleDeleteResDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleInsertReqDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleInsertResDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleUpdateReqDto;
import com.lawencon.elearning.dto.materialschedule.MaterialScheduleUpdateResDto;
import com.lawencon.elearning.dto.materialschedule.MaterialSchedulesDto;

public interface MaterialScheduleService {

	MaterialScheduleInsertResDto insert(MaterialScheduleInsertReqDto data);

	MaterialScheduleUpdateResDto update(MaterialScheduleUpdateReqDto data);

	MaterialScheduleDto getById(Long id);

	MaterialSchedulesDto getAll(Long classId);

	MaterialScheduleDeleteResDto deleteById(Long id);
}
