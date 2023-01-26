package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.ExamScheduleDao;
import com.lawencon.elearning.model.ExamSchedule;

@Repository
public class ExamScheduleDaoImpl extends BaseDaoImpl implements ExamScheduleDao {
	
	@Override
	public ExamSchedule insert(final ExamSchedule data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public ExamSchedule update(final ExamSchedule data) {
		final ExamSchedule examScheduleUpdated = this.em.merge(data);
		this.em.flush();

		return examScheduleUpdated;
	}

	@Override
	public Optional<ExamSchedule> getById(final Long id) {
		final ExamSchedule examSchedule = this.em.find(ExamSchedule.class, id);
		this.em.detach(examSchedule);
		
		final Optional<ExamSchedule> examScheduleOptional = Optional.ofNullable(examSchedule);
		
		return examScheduleOptional;
	}

	@Override
	public List<ExamSchedule> getAll(final Long studentId, final Long classId) {
		final String sql = 
				" SELECT tes FROM ExamSchedule tes "
				+ "INNER JOIN FETCH tes.exam te "
				+ "INNER JOIN FETCH te.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "INNER JOIN FETCH ClassroomDetail tcd "
				+ "ON tc = tcd.classroom "
				+ "INNER JOIN tcd.student student "
				+ "WHERE student.id = :studentId AND tc.id = :classId " 
				+ "ORDER BY tes.id ASC";
		
		final List<ExamSchedule> examSchedules = this.em.createQuery(sql, ExamSchedule.class)
				.setParameter("studentId", studentId)
				.setParameter("classId", classId)
				.getResultList();
		return examSchedules;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ExamSchedule WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
