package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.ForumDao;
import com.lawencon.elearning.model.Forum;

@Repository
public class ForumDaoImpl extends BaseDaoImpl implements ForumDao{
	
	@Override
	public Forum insert(final Forum data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Forum update(final Forum data) {
		final Forum forumUpdated = this.em.merge(data);
		this.em.flush();

		return forumUpdated;
	}

	@Override
	public Optional<Forum> getById(final Long id) {
		final Forum forum = this.em.find(Forum.class, id);
		this.em.detach(forum);
		
		final Optional<Forum> forumOptional = Optional.ofNullable(forum);
		
		return forumOptional;
	}

	@Override
	public List<Forum> getAll() {
		final String sql = " SELECT f FROM Forum f "
				+ "INNER JOIN FETCH f.classrommDetail cd"
				+ "INNER JOIN FETCH cd.student std";

		final List<Forum> forums = this.em.createQuery(sql, Forum.class)
		.getResultList();
		return forums;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Forum WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
