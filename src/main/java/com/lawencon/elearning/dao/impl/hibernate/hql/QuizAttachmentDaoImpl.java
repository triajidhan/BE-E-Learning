package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.QuizAttachmentDao;
import com.lawencon.elearning.model.QuizAttachment;

@Repository
public class QuizAttachmentDaoImpl extends BaseDaoImpl implements QuizAttachmentDao{

	
	@Override
	public QuizAttachment insert(final QuizAttachment data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public QuizAttachment update(final QuizAttachment data) {
		final QuizAttachment quizAttachmentUpdated = this.em.merge(data);
		this.em.flush();

		return quizAttachmentUpdated;
	}

	@Override
	public Optional<QuizAttachment> getById(final Long id) {
		final QuizAttachment quizAttachment = this.em.find(QuizAttachment.class, id);
		this.em.detach(quizAttachment);
		
		final Optional<QuizAttachment> quizAttachmentOptional = Optional.ofNullable(quizAttachment);
		
		return quizAttachmentOptional;
	}

	@Override
	public List<QuizAttachment> getAll() {
		final String sql = " SELECT qa FROM QuizAttachment qa"
				+ "INNER JOIN FETCH qa.File ";

		final List<QuizAttachment> quizAttachments = this.em.createQuery(sql, QuizAttachment.class)
		.getResultList();
		return quizAttachments;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM QuizAttachment WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
