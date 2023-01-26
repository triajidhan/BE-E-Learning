package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import com.lawencon.elearning.dao.QuizDao;
import com.lawencon.elearning.model.Quiz;

public class QuizDaoImpl extends BaseDaoImpl implements QuizDao {
	
	@Override
	public Quiz insert(final Quiz data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Quiz update(final Quiz data) {
		final Quiz quizUpdated = this.em.merge(data);
		this.em.flush();

		return quizUpdated;
	}

	@Override
	public Optional<Quiz> getById(final Long id) {
		final Quiz quiz = this.em.find(Quiz.class, id);
		this.em.detach(quiz);
		
		final Optional<Quiz> quizOptional = Optional.ofNullable(quiz);
		
		return quizOptional;
	}

	@Override
	public List<Quiz> getAll() {
		final String sql = " SELECT q FROM Quiz q";

		final List<Quiz> quizes = this.em.createQuery(sql, Quiz.class)
		.getResultList();
		return quizes;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Quiz WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
