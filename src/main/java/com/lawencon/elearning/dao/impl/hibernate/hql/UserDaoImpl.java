package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.UserDao;
import com.lawencon.elearning.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {


	@Override
	public User insert(final User data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public User update(final User data) {
		final User userUpdated = this.em.merge(data);
		this.em.flush();

		return userUpdated;
	}

	@Override
	public Optional<User> getById(final Long id) {
		final User user = this.em.find(User.class, id);
		this.em.detach(user);
		
		final Optional<User> userOptional = Optional.ofNullable(user);
		
		return userOptional;
	}

	@Override
	public List<User> getAll(final String roleCode) {		
		final String sql = " SELECT us "
				+ "FROM User us "
				+ "INNER JOIN FETCH us.role rl "
				+ "INNER JOIN FETCH us.photo ph "
				+ "WHERE rl.roleCode = :roleCode "
				+ "ORDER BY us.id ASC";
		
		final List<User> users = this.em.createQuery(sql, User.class)
				.setParameter("roleCode", roleCode)
				.getResultList();
		return users;
	}
	

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM User WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}

	@Override
	public Optional<User> getByEmail(final String userEmail) {
		final String sql = " SELECT us FROM User us "
				+ "INNER JOIN FETCH us.role "
				+ "WHERE us.userEmail = :userEmail AND us.isActive = true ";
		
		final User user = this.em.createQuery(sql, User.class)
				.setParameter("userEmail", userEmail)
				.getSingleResult();
	
		Optional<User> userOptional = Optional.ofNullable(user);
	
		return userOptional;
	}
}
