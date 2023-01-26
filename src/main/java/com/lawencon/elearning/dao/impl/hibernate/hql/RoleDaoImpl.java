package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.RoleDao;
import com.lawencon.elearning.model.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {

	@Override
	public Role insert(final Role data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public Role update(final Role data) {
		final Role roleUpdated = this.em.merge(data);
		this.em.flush();

		return roleUpdated;
	}

	@Override
	public Optional<Role> getById(final Long id) {
		final Role role = this.em.find(Role.class, id);
		this.em.detach(role);
		
		final Optional<Role> roleOptional = Optional.ofNullable(role);
		
		return roleOptional;
	}

	@Override
	public List<Role> getAll() {
		final String sql = " SELECT r FROM Role r";

		final List<Role> roles = this.em.createQuery(sql, Role.class)
		.getResultList();
		return roles;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Role WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
