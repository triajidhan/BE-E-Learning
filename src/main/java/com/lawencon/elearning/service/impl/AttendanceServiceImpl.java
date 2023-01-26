package com.lawencon.elearning.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.constant.Message;
import com.lawencon.elearning.dao.AttendanceDao;
import com.lawencon.elearning.dao.ClassroomDetailDao;
import com.lawencon.elearning.dao.ExamCollectionDao;
import com.lawencon.elearning.dao.ExamScheduleDao;
import com.lawencon.elearning.dao.MaterialScheduleDao;
import com.lawencon.elearning.dao.QuizCollectionDao;
import com.lawencon.elearning.dao.QuizScheduleDao;
import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.dto.attendance.AttendanceDataDto;
import com.lawencon.elearning.dto.attendance.AttendanceDto;
import com.lawencon.elearning.dto.attendance.AttendanceInsertDataResDto;
import com.lawencon.elearning.dto.attendance.AttendanceInsertReqDto;
import com.lawencon.elearning.dto.attendance.AttendanceInsertResDto;
import com.lawencon.elearning.dto.attendance.AttendanceUpdateDataResDto;
import com.lawencon.elearning.dto.attendance.AttendanceUpdateReqDto;
import com.lawencon.elearning.dto.attendance.AttendanceUpdateResDto;
import com.lawencon.elearning.dto.attendance.AttendancesDto;
import com.lawencon.elearning.model.Attendance;
import com.lawencon.elearning.model.ClassroomDetail;
import com.lawencon.elearning.model.ExamCollection;
import com.lawencon.elearning.model.ExamSchedule;
import com.lawencon.elearning.model.MaterialSchedule;
import com.lawencon.elearning.model.QuizCollection;
import com.lawencon.elearning.model.QuizSchedule;
import com.lawencon.elearning.model.User;
import com.lawencon.elearning.service.AttendanceService;
import com.lawencon.elearning.service.PrincipalService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceDao attendanceDao;
	@Autowired
	private MaterialScheduleDao materialScheduleDao;
	@Autowired
	private QuizScheduleDao quizScheduleDao;
	@Autowired
	private ExamScheduleDao examScheduleDao;
	@Autowired
	private ClassroomDetailDao classroomDetailDao;
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private ExamCollectionDao examCollectionDao;
	@Autowired
	private QuizCollectionDao quizCollectionDao;
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public AttendanceInsertResDto studentAttend(final AttendanceInsertReqDto data) {
		final AttendanceInsertResDto insertRes = new AttendanceInsertResDto();
		final AttendanceInsertDataResDto dataRes = new AttendanceInsertDataResDto();

		final Attendance attendance = new Attendance();
		attendance.setAttendance(false);
		attendance.setAttendanceTime(LocalDateTime.now());
		if (data.getMaterialScheduleId() != null) {
			final Optional<MaterialSchedule> materialScheduleOptional = materialScheduleDao.getById(data.getMaterialScheduleId()); 
			attendance.setMaterialSchedule(materialScheduleOptional.get());
		} else if (data.getQuizScheduleId() != null) {
			final Optional<QuizSchedule> quizScheduleOptional = quizScheduleDao.getById(data.getQuizScheduleId()); 
			attendance.setQuizSchedule(quizScheduleOptional.get());
			
			final QuizCollection quizCollection = new QuizCollection();
			quizCollection.setQuizSchedule(quizScheduleOptional.get());
			quizCollection.setIsActive(false);
			quizCollection.setCreatedBy(principalService.getPrincipal().getId());

			quizCollectionDao.insert(quizCollection);
		} else {
			final Optional<ExamSchedule> examScheduleOptional = examScheduleDao.getById(data.getExamScheduleId()); 
			attendance.setExamSchedule(examScheduleOptional.get());
			
			final ExamCollection examCollection = new ExamCollection();
			examCollection.setExamSchedule(examScheduleOptional.get());
			examCollection.setIsActive(false);
			examCollection.setCreatedBy(principalService.getPrincipal().getId());

			examCollectionDao.insert(examCollection);
		}
		final Optional<ClassroomDetail> classroomDetailOptional = classroomDetailDao.getById(data.getClassroomDetailId());
		attendance.setClassroomDetail(classroomDetailOptional.get());

		attendance.setCreatedBy(principalService.getPrincipal().getId());
		final Attendance attendanceInsert = attendanceDao.insert(attendance);	
		
		dataRes.setId(attendanceInsert.getId());
		insertRes.setData(dataRes);
		insertRes.setMessage(Message.INSERT.getMessageName());

		return insertRes;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public AttendanceUpdateResDto approveAttend(final AttendanceUpdateReqDto data) {
		final Optional<Attendance> attendanceOptional = attendanceDao.getById(data.getId());
		final AttendanceUpdateResDto updateRes = new AttendanceUpdateResDto();
		final AttendanceUpdateDataResDto dataRes = new AttendanceUpdateDataResDto();

		Attendance attendanceUpdate = null;
		if (attendanceOptional.isPresent()) {
			attendanceUpdate = attendanceOptional.get();
			attendanceUpdate.setAttendance(true);

			attendanceUpdate.setUpdatedBy(principalService.getPrincipal().getId());
			attendanceUpdate.setIsActive(true);
			attendanceUpdate.setId(data.getId());			
			attendanceUpdate = attendanceDao.update(attendanceUpdate);
			dataRes.setVersion(attendanceUpdate.getVersion());
			updateRes.setData(dataRes);
			updateRes.setMessage(Message.UPDATE.getMessageName());
		}
		return updateRes;		
	}

	@Override
	public AttendanceDto getById(final Long id) {
		final Optional<Attendance> attendanceOptional = attendanceDao.getById(id);
		final AttendanceDataDto dataDto = new AttendanceDataDto();
		final AttendanceDto attendanceDto = new AttendanceDto();
		if (attendanceOptional.isPresent()) {
			dataDto.setId(id);
			dataDto.setAttendanceTime(attendanceOptional.get().getAttendanceTime());
			final Optional<User> studentOptional = userDao.getById(attendanceOptional.get().getCreatedBy());
			dataDto.setFullName(studentOptional.get().getFullName());
			dataDto.setAtteandance(attendanceOptional.get().getAttendance());
			if (attendanceOptional.get().getMaterialSchedule() != null) {
				dataDto.setMaterialName(attendanceOptional.get().getMaterialSchedule().getMaterial().getMaterialName());
			} else if (attendanceOptional.get().getQuizSchedule() != null) {
				dataDto.setQuizName(attendanceOptional.get().getQuizSchedule().getQuiz().getQuizName());
			} else {
				dataDto.setExamName(attendanceOptional.get().getExamSchedule().getExam().getExamName());
			}
			dataDto.setClassroomName(attendanceOptional.get().getClassroomDetail().getClassroom().getClassroomName());
			dataDto.setVersion(attendanceOptional.get().getVersion());
			attendanceDto.setData(dataDto);
		}
		return attendanceDto;	
	}

	@Override
	public AttendancesDto getMaterial(final Long classId) {
		final Long teacherId = principalService.getPrincipal().getId();
		final List<Attendance> attendances = attendanceDao.getMaterial(teacherId, false, classId);
		final List<AttendanceDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < attendances.size(); i++) {
			final Attendance attendance = attendances.get(i);
			final AttendanceDataDto dataDto = new AttendanceDataDto();
			dataDto.setId(attendance.getId());
			dataDto.setAttendanceTime(attendance.getAttendanceTime());
			final Optional<User> studentOptional = userDao.getById(attendance.getCreatedBy());
			dataDto.setFullName(studentOptional.get().getFullName());
			dataDto.setAtteandance(attendance.getAttendance());
			dataDto.setMaterialName(attendance.getMaterialSchedule().getMaterial().getMaterialName());
			dataDto.setClassroomName(attendance.getClassroomDetail().getClassroom().getClassroomName());
			dataDto.setVersion(attendance.getVersion());
			dataDtos.add(dataDto);
		}
		final AttendancesDto attendancesDto = new AttendancesDto();
		attendancesDto.setData(dataDtos);

		return attendancesDto;
	}
	
	@Override
	public AttendancesDto getQuiz(final Long classId) {
		final Long teacherId = principalService.getPrincipal().getId();
		final List<Attendance> attendances = attendanceDao.getQuiz(teacherId, false, classId);
		final List<AttendanceDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < attendances.size(); i++) {
			final Attendance attendance = attendances.get(i);
			final AttendanceDataDto dataDto = new AttendanceDataDto();
			dataDto.setId(attendance.getId());
			dataDto.setAttendanceTime(attendance.getAttendanceTime());
			final Optional<User> studentOptional = userDao.getById(attendance.getCreatedBy());
			dataDto.setFullName(studentOptional.get().getFullName());
			dataDto.setAtteandance(attendance.getAttendance());
			if (attendance.getQuizSchedule() != null) {
				dataDto.setQuizName(attendance.getQuizSchedule().getQuiz().getQuizName());
			}
			dataDto.setClassroomName(attendance.getClassroomDetail().getClassroom().getClassroomName());
			dataDto.setVersion(attendance.getVersion());
			dataDtos.add(dataDto);
		}
		final AttendancesDto attendancesDto = new AttendancesDto();
		attendancesDto.setData(dataDtos);

		return attendancesDto;
	}
	
	@Override
	public AttendancesDto getExam(final Long classId) {
		final Long teacherId = principalService.getPrincipal().getId();
		final List<Attendance> attendances = attendanceDao.getExam(teacherId, false, classId);
		final List<AttendanceDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < attendances.size(); i++) {
			final Attendance attendance = attendances.get(i);
			final AttendanceDataDto dataDto = new AttendanceDataDto();
			dataDto.setId(attendance.getId());
			dataDto.setAttendanceTime(attendance.getAttendanceTime());
			final Optional<User> studentOptional = userDao.getById(attendance.getCreatedBy());
			dataDto.setFullName(studentOptional.get().getFullName());
			dataDto.setAtteandance(attendance.getAttendance());
			if (attendance.getExamSchedule()  != null) {
				dataDto.setExamName(attendance.getExamSchedule().getExam().getExamName());
			}
			dataDto.setClassroomName(attendance.getClassroomDetail().getClassroom().getClassroomName());
			dataDto.setVersion(attendance.getVersion());
			dataDtos.add(dataDto);
		}
		final AttendancesDto attendancesDto = new AttendancesDto();
		attendancesDto.setData(dataDtos);

		return attendancesDto;
	}

	@Override
	public AttendancesDto getMaterialStudent(final Long classId) {
		final Long studentId = principalService.getPrincipal().getId();
		final List<Attendance> attendances = attendanceDao.getMaterialStudent(studentId, true, classId);
		final List<AttendanceDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < attendances.size(); i++) {
			final Attendance attendance = attendances.get(i);
			final AttendanceDataDto dataDto = new AttendanceDataDto();
			dataDto.setId(attendance.getId());
			dataDto.setAttendanceTime(attendance.getAttendanceTime());
			final Optional<User> studentOptional = userDao.getById(attendance.getCreatedBy());
			dataDto.setFullName(studentOptional.get().getFullName());
			dataDto.setAtteandance(attendance.getAttendance());
			dataDto.setMaterialName(attendance.getMaterialSchedule().getMaterial().getMaterialName());
			dataDto.setClassroomName(attendance.getClassroomDetail().getClassroom().getClassroomName());
			dataDto.setVersion(attendance.getVersion());
			dataDtos.add(dataDto);
		}
		final AttendancesDto attendancesDto = new AttendancesDto();
		attendancesDto.setData(dataDtos);

		return attendancesDto;
	}

	@Override
	public AttendancesDto getQuizStudent(final Long classId) {
		final Long studentId = principalService.getPrincipal().getId();
		final List<Attendance> attendances = attendanceDao.getQuizStudent(studentId, true, classId);
		final List<AttendanceDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < attendances.size(); i++) {
			final Attendance attendance = attendances.get(i);
			final AttendanceDataDto dataDto = new AttendanceDataDto();
			dataDto.setId(attendance.getId());
			dataDto.setAttendanceTime(attendance.getAttendanceTime());
			final Optional<User> studentOptional = userDao.getById(attendance.getCreatedBy());
			dataDto.setFullName(studentOptional.get().getFullName());
			dataDto.setAtteandance(attendance.getAttendance());
			if (attendance.getQuizSchedule() != null) {
				dataDto.setQuizName(attendance.getQuizSchedule().getQuiz().getQuizName());
			}
			dataDto.setClassroomName(attendance.getClassroomDetail().getClassroom().getClassroomName());
			dataDto.setVersion(attendance.getVersion());
			dataDtos.add(dataDto);
		}
		final AttendancesDto attendancesDto = new AttendancesDto();
		attendancesDto.setData(dataDtos);

		return attendancesDto;
	}

	@Override
	public AttendancesDto getExamStudent(final Long classId) {
		final Long studentId = principalService.getPrincipal().getId();
		final List<Attendance> attendances = attendanceDao.getExamStudent(studentId, true, classId);
		final List<AttendanceDataDto> dataDtos = new ArrayList<>();

		for (int i = 0; i < attendances.size(); i++) {
			final Attendance attendance = attendances.get(i);
			final AttendanceDataDto dataDto = new AttendanceDataDto();
			dataDto.setId(attendance.getId());
			dataDto.setAttendanceTime(attendance.getAttendanceTime());
			final Optional<User> studentOptional = userDao.getById(attendance.getCreatedBy());
			dataDto.setFullName(studentOptional.get().getFullName());
			dataDto.setAtteandance(attendance.getAttendance());
			if (attendance.getExamSchedule()  != null) {
				dataDto.setExamName(attendance.getExamSchedule().getExam().getExamName());
			}
			dataDto.setClassroomName(attendance.getClassroomDetail().getClassroom().getClassroomName());
			dataDto.setVersion(attendance.getVersion());
			dataDtos.add(dataDto);
		}
		final AttendancesDto attendancesDto = new AttendancesDto();
		attendancesDto.setData(dataDtos);

		return attendancesDto;
	}

}
