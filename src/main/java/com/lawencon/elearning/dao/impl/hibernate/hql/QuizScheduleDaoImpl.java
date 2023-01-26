package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.QuizScheduleDao;
import com.lawencon.elearning.model.QuizSchedule;

@Repository
public class QuizScheduleDaoImpl extends BaseDaoImpl implements QuizScheduleDao {

	
	@Override
	public QuizSchedule insert(final QuizSchedule data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public QuizSchedule update(final QuizSchedule data) {
		final QuizSchedule quizScheduleUpdated = this.em.merge(data);
		this.em.flush();

		return quizScheduleUpdated;
	}

	@Override
	public Optional<QuizSchedule> getById(final Long id) {
		final QuizSchedule quizSchedule = this.em.find(QuizSchedule.class, id);
		this.em.detach(quizSchedule);
		
		final Optional<QuizSchedule> quizScheduleOptional = Optional.ofNullable(quizSchedule);
		
		return quizScheduleOptional;
	}

	@Override
	public List<QuizSchedule> getAll(final Long studentId, final Long classId) {
		final String sql = 
				" SELECT tqs FROM QuizSchedule tqs "
				+ "INNER JOIN FETCH tqs.quiz tq "
				+ "INNER JOIN FETCH tq.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "INNER JOIN FETCH ClassroomDetail tcd "
				+ "ON tc = tcd.classroom "
				+ "INNER JOIN tcd.student student "
				+ "WHERE student.id = :studentId AND tc.id = :classId " 
				+ " ORDER BY tqs.id ASC";
		
		final List<QuizSchedule> quizSchedules = this.em.createQuery(sql, QuizSchedule.class)
				.setParameter("studentId", studentId)
				.setParameter("classId", classId)
				.getResultList();
		return quizSchedules;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM QuizSchedule WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}