package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.AttendanceDao;
import com.lawencon.elearning.model.Attendance;

@Repository
public class AttendanceDaoImpl extends BaseDaoImpl implements AttendanceDao {

	
	@Override
	public Attendance insert(final Attendance data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Attendance update(final Attendance data) {
		final Attendance attendanceUpdated = this.em.merge(data);
		this.em.flush();

		return attendanceUpdated;
	}

	@Override
	public Optional<Attendance> getById(final Long id) {
		final Attendance attendance = this.em.find(Attendance.class, id);
		this.em.detach(attendance);
		
		final Optional<Attendance> attendanceOptional = Optional.ofNullable(attendance);
		
		return attendanceOptional;
	}

	@Override
	public List<Attendance> getMaterial(final Long teacherId, final boolean approve, final Long classId) {
		final String sql = 
				" SELECT ta "
				+ "FROM Attendance ta "
				+ "LEFT JOIN FETCH ta.classroomDetail tcd "
				+ "LEFT JOIN FETCH tcd.student student "
				+ "LEFT JOIN FETCH ta.materialSchedule tms "
				+ "LEFT JOIN FETCH tms.material tm "
				+ "INNER JOIN FETCH tm.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "WHERE ta.attendance = :approve AND teacher.id = :teacherId "
				+ "AND tc.id = :classId "
				+ "AND ta.isActive = true "
				+ "ORDER BY ta.id ASC";
		
		final List<Attendance> attendances = this.em.createQuery(sql, Attendance.class)
				.setParameter("approve", approve)
				.setParameter("teacherId", teacherId)
				.setParameter("classId", classId)
				.getResultList();
		return attendances;
	}
	
	@Override
	public List<Attendance> getQuiz(final Long teacherId, final boolean approve, final Long classId) {
		final String sql = 
				" SELECT ta "
				+ "FROM Attendance ta "
				+ "LEFT JOIN FETCH ta.classroomDetail tcd "
				+ "LEFT JOIN FETCH tcd.student student "
				+ "LEFT JOIN FETCH ta.quizSchedule tqs "
				+ "LEFT JOIN FETCH tqs.quiz tq "
				+ "INNER JOIN FETCH tq.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "WHERE ta.attendance = :approve AND teacher.id = :teacherId "
				+ "AND tc.id = :classId "
				+ "AND ta.isActive = true "
				+ "ORDER BY ta.id ASC";
		
		final List<Attendance> attendances = this.em.createQuery(sql, Attendance.class)
				.setParameter("approve", approve)
				.setParameter("teacherId", teacherId)
				.setParameter("classId", classId)
				.getResultList();
		return attendances;
	}
	
	@Override
	public List<Attendance> getExam(final Long teacherId, final boolean approve, final Long classId) {
		final String sql = 
				" SELECT ta "
				+ "FROM Attendance ta "
				+ "LEFT JOIN FETCH ta.classroomDetail tcd "
				+ "LEFT JOIN FETCH tcd.student student "
				+ "LEFT JOIN FETCH ta.examSchedule tes "
				+ "LEFT JOIN FETCH tes.exam te "
				+ "INNER JOIN FETCH te.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "WHERE ta.attendance = :approve AND teacher.id = :teacherId "
				+ "AND tc.id = :classId "
				+ "AND ta.isActive = true "
				+ "ORDER BY ta.id ASC";
		
		final List<Attendance> attendances = this.em.createQuery(sql, Attendance.class)
				.setParameter("approve", approve)
				.setParameter("teacherId", teacherId)
				.setParameter("classId", classId)
				.getResultList();
		return attendances;
	}

	@Override
	public List<Attendance> getMaterialStudent(final Long studentId, final boolean approve, final Long classId) {
		final String sql = 
				" SELECT ta "
				+ "FROM Attendance ta "
				+ "LEFT JOIN FETCH ta.classroomDetail tcd "
				+ "LEFT JOIN FETCH tcd.student student "
				+ "LEFT JOIN FETCH ta.materialSchedule tms "
				+ "LEFT JOIN FETCH tms.material tm "
				+ "INNER JOIN FETCH tm.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "WHERE ta.attendance = :approve AND student.id = :studentId "
				+ "AND tc.id = :classId "
				+ "AND ta.isActive = true "
				+ "ORDER BY ta.id ASC";
		
		final List<Attendance> attendances = this.em.createQuery(sql, Attendance.class)
				.setParameter("approve", approve)
				.setParameter("studentId", studentId)
				.setParameter("classId", classId)
				.getResultList();
		return attendances;
	}

	@Override
	public List<Attendance> getQuizStudent(final Long studentId, final boolean approve, final Long classId) {
		final String sql = 
				" SELECT ta "
				+ "FROM Attendance ta "
				+ "LEFT JOIN FETCH ta.classroomDetail tcd "
				+ "LEFT JOIN FETCH tcd.student student "
				+ "LEFT JOIN FETCH ta.quizSchedule tqs "
				+ "LEFT JOIN FETCH tqs.quiz tq "
				+ "INNER JOIN FETCH tq.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "WHERE ta.attendance = :approve AND student.id = :studentId "
				+ "AND tc.id = :classId "
				+ "AND ta.isActive = true "
				+ "ORDER BY ta.id ASC";
		
		final List<Attendance> attendances = this.em.createQuery(sql, Attendance.class)
				.setParameter("approve", approve)
				.setParameter("studentId", studentId)
				.setParameter("classId", classId)
				.getResultList();
		return attendances;
	}

	@Override
	public List<Attendance> getExamStudent(final Long studentId, final boolean approve, final Long classId) {
		final String sql = 
				" SELECT ta "
				+ "FROM Attendance ta "
				+ "LEFT JOIN FETCH ta.classroomDetail tcd "
				+ "LEFT JOIN FETCH tcd.student student "
				+ "LEFT JOIN FETCH ta.examSchedule tes "
				+ "LEFT JOIN FETCH tes.exam te "
				+ "INNER JOIN FETCH te.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "WHERE ta.attendance = :approve AND student.id = :studentId "
				+ "AND tc.classroomCode = :classroomCode "
				+ "AND ta.isActive = true "
				+ "ORDER BY ta.id ASC";
		
		final List<Attendance> attendances = this.em.createQuery(sql, Attendance.class)
				.setParameter("approve", approve)
				.setParameter("studentId", studentId)
				.setParameter("classId", classId)
				.getResultList();
		return attendances;
	}
	
	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Attendance WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}

}
