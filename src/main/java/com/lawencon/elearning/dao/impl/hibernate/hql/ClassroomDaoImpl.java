package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.ClassroomDao;
import com.lawencon.elearning.model.Classroom;

@Repository
public class ClassroomDaoImpl extends BaseDaoImpl implements ClassroomDao{

	
	@Override
	public Classroom insert(final Classroom data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Classroom update(final Classroom data) {
		final Classroom classroomUpdated = this.em.merge(data);
		this.em.flush();

		return classroomUpdated;
	}

	@Override
	public Optional<Classroom> getById(final Long id) {
		final Classroom classroom = this.em.find(Classroom.class, id);
		this.em.detach(classroom);
		
		final Optional<Classroom> classroomOptional = Optional.ofNullable(classroom);
		
		return classroomOptional;
	}
	
	@Override
	public List<Classroom> getAll() {
		final String sql = 
				" SELECT cr "
				+ "FROM Classroom cr "
				+ "INNER JOIN FETCH cr.teacher teacher "
				+ "ORDER BY cr.id ASC";
		
		final List<Classroom> classrooms = this.em.createQuery(sql, Classroom.class)
				.getResultList();
		return classrooms;	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Classroom WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
