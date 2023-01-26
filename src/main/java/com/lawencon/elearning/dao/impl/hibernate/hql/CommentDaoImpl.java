package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.CommentDao;
import com.lawencon.elearning.model.Comment;

@Repository
public class CommentDaoImpl extends BaseDaoImpl implements CommentDao{
	
	
	@Override
	public Comment insert(final Comment data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Comment update(final Comment data) {
		final Comment commentUpdated = this.em.merge(data);
		this.em.flush();

		return commentUpdated;
	}

	@Override
	public Optional<Comment> getById(final Long id) {
		final Comment comment = this.em.find(Comment.class, id);
		this.em.detach(comment);
		
		final Optional<Comment> commentOptional = Optional.ofNullable(comment);
		
		return commentOptional;
	}

	@Override
	public List<Comment> getAll() {
		final String sql = " SELECT c FROM Comment c "
				+ "INNER JOIN FETCH c.Forum ";

		final List<Comment> comments = this.em.createQuery(sql, Comment.class)
		.getResultList();
		return comments;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Comment WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
