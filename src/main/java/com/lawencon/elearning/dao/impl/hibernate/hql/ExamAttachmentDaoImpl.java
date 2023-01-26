package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.ExamAttachmentDao;
import com.lawencon.elearning.model.ExamAttachment;

@Repository
public class ExamAttachmentDaoImpl extends BaseDaoImpl implements ExamAttachmentDao {

	
	@Override
	public ExamAttachment insert(final ExamAttachment data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public ExamAttachment update(final ExamAttachment data) {
		final ExamAttachment examAttachmentUpdated = this.em.merge(data);
		this.em.flush();

		return examAttachmentUpdated;
	}

	@Override
	public Optional<ExamAttachment> getById(final Long id) {
		final ExamAttachment examAttachment = this.em.find(ExamAttachment.class, id);
		this.em.detach(examAttachment);
		
		final Optional<ExamAttachment> examAttachmentOptional = Optional.ofNullable(examAttachment);
		
		return examAttachmentOptional;
	}

	public List<ExamAttachment> getAll() {
		final String sql = " SELECT ea FROM ExamAttachment ea"
				+ "INNER JOIN FETCH ea.File ";

		final List<ExamAttachment> examAttachments = this.em.createQuery(sql, ExamAttachment.class)
		.getResultList();
		return examAttachments;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ExamAttachment WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
