package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.QuizCollectionDao;
import com.lawencon.elearning.model.QuizCollection;

@Repository
public class QuizCollectionDaoImpl extends BaseDaoImpl implements QuizCollectionDao{
	
	@Override
	public QuizCollection insert(final QuizCollection data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public QuizCollection update(final QuizCollection data) {
		final QuizCollection quizCollectionUpdated = this.em.merge(data);
		this.em.flush();

		return quizCollectionUpdated;
	}

	@Override
	public Optional<QuizCollection> getById(final Long id) {
		final QuizCollection quizCollection = this.em.find(QuizCollection.class, id);
		this.em.detach(quizCollection);
		
		final Optional<QuizCollection> quizCollectionOptional = Optional.ofNullable(quizCollection);
		
		return quizCollectionOptional;
	}

	@Override
	public List<QuizCollection> getAll(final Long studentId, final Long classId) {
		final String sql = 
				" SELECT tqc "
				+ "FROM QuizCollection tqc "
				+ "INNER JOIN FETCH tqc.quizSchedule tqs "
				+ "INNER JOIN FETCH tqs.quiz tq "
				+ "INNER JOIN FETCH tq.classroom tc "
				+ "WHERE tqc.createdBy = :studentId "
				+ "AND tc.id = :classId "
				+ "ORDER BY tqc.id ASC";
		
		final List<QuizCollection> quizCollections = this.em.createQuery(sql, QuizCollection.class)
				.setParameter("studentId", studentId)
				.setParameter("classId", classId)
				.getResultList();
		return quizCollections;	
	}
	
	@Override
	public List<QuizCollection> getAllStudent(final Long teacherId, final Long classId) {
		final String sql = 
				" SELECT tqc  "
				+ "FROM QuizCollection tqc "
				+ "INNER JOIN FETCH tqc.quizSchedule tqs "
				+ "INNER JOIN FETCH tqs.quiz tq "
				+ "INNER JOIN FETCH tq.classroom tc "
				+ "INNER JOIN FETCH tc.teacher tch "
				+ "WHERE tch.id = :teacherId AND tqc.isActive = true "
				+ "AND tc.id = :classId "
				+ "ORDER BY tqc.id ASC";		
		final List<QuizCollection> quizCollections = this.em.createQuery(sql, QuizCollection.class)
				.setParameter("teacherId", teacherId)
				.setParameter("classId", classId)
				.getResultList();
		return quizCollections;	
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM QuizCollection WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
