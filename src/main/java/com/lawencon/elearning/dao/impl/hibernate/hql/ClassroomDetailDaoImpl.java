package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.ClassroomDetailDao;
import com.lawencon.elearning.model.ClassroomDetail;

@Repository
public class ClassroomDetailDaoImpl extends BaseDaoImpl implements ClassroomDetailDao {
	
	@Override
	public ClassroomDetail insert(final ClassroomDetail data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public ClassroomDetail update(final ClassroomDetail data) {
		final ClassroomDetail classroomDetailUpdated = this.em.merge(data);
		this.em.flush();

		return classroomDetailUpdated;
	}

	@Override
	public Optional<ClassroomDetail> getById(final Long id) {
		final ClassroomDetail classroomDetail = this.em.find(ClassroomDetail.class, id);
		this.em.detach(classroomDetail);
		
		final Optional<ClassroomDetail> classroomDetailOptional = Optional.ofNullable(classroomDetail);
		
		return classroomDetailOptional;
	}
	
	@Override
	public List<ClassroomDetail> getAll(final Long studentId) {
		final String sql = 
				" SELECT cd "
				+ "FROM ClassroomDetail cd "
				+ "INNER JOIN FETCH cd.classroom cr "
				+ "INNER JOIN FETCH cd.student std "
				+ "WHERE std.id = :studentId " 
				+ "ORDER BY cd.id ASC";
		
		final List<ClassroomDetail> classroomDetails = this.em.createQuery(sql, ClassroomDetail.class)
				.setParameter("studentId", studentId)
				.getResultList();
		return classroomDetails;	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ClassroomDetail WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
	
}
