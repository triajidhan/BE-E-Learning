package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.ExamDao;
import com.lawencon.elearning.model.Exam;

@Repository
public class ExamDaoImpl extends BaseDaoImpl implements ExamDao {
	
	@Override
	public Exam insert(final Exam data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Exam update(final Exam data) {
		final Exam examUpdated = this.em.merge(data);
		this.em.flush();

		return examUpdated;
	}

	@Override
	public Optional<Exam> getById(final Long id) {
		final Exam exam = this.em.find(Exam.class, id);
		this.em.detach(exam);
		
		final Optional<Exam> examOptional = Optional.ofNullable(exam);
		
		return examOptional;
	}

	@Override
	public List<Exam> getAll() {
		final String sql = " SELECT e FROM Exam e";

		final List<Exam> exams = this.em.createQuery(sql, Exam.class)
		.getResultList();
		return exams;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Exam WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
