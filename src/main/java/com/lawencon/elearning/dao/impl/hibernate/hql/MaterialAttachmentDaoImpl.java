package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.MaterialAttachmentDao;
import com.lawencon.elearning.model.MaterialAttachment;

@Repository
public class MaterialAttachmentDaoImpl extends BaseDaoImpl implements MaterialAttachmentDao {

	@Override
	public MaterialAttachment insert(final MaterialAttachment data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public MaterialAttachment update(final MaterialAttachment data) {
		final MaterialAttachment materialAttachmentUpdated = this.em.merge(data);
		this.em.flush();

		return materialAttachmentUpdated;
	}

	@Override
	public Optional<MaterialAttachment> getById(final Long id) {
		final MaterialAttachment materialAttachment = this.em.find(MaterialAttachment.class, id);
		this.em.detach(materialAttachment);
		
		final Optional<MaterialAttachment> materialAttachmentOptional = Optional.ofNullable(materialAttachment);
		
		return materialAttachmentOptional;
	}

	@Override
	public List<MaterialAttachment> getAll() {
		final String sql = " SELECT ma FROM MaterialAttachment ma"
				+ "INNER JOIN FETCH ma.File ";

		final List<MaterialAttachment> materialAttachments = this.em.createQuery(sql, MaterialAttachment.class)
		.getResultList();
		return materialAttachments;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM MaterialAttachment WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
