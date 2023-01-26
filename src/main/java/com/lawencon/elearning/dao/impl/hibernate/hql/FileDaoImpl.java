package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.FileDao;
import com.lawencon.elearning.model.File;

@Repository
public class FileDaoImpl extends BaseDaoImpl implements FileDao {

	@Override
	public File insert(final File data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public File update(final File data) {
		final File fileUpdated = this.em.merge(data);
		this.em.flush();

		return fileUpdated;
	}

	@Override
	public Optional<File> getById(final Long id) {
		final File file = this.em.find(File.class, id);
		this.em.detach(file);
		
		final Optional<File> fileOptional = Optional.ofNullable(file);
		
		return fileOptional;
	}

	@Override
	public List<File> getAll() {
		final String sql = " SELECT f FROM File f";

		final List<File> files = this.em.createQuery(sql, File.class)
		.getResultList();
		return files;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM File WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
