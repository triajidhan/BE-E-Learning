package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.ExamCollectionDao;
import com.lawencon.elearning.model.ExamCollection;

@Repository
public class ExamCollectionDaoImpl extends BaseDaoImpl implements ExamCollectionDao {

	
	@Override
	public ExamCollection insert(final ExamCollection data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public ExamCollection update(final ExamCollection data) {
		final ExamCollection examCollectionUpdated = this.em.merge(data);
		this.em.flush();

		return examCollectionUpdated;
	}

	@Override
	public Optional<ExamCollection> getById(final Long id) {
		final ExamCollection examCollection = this.em.find(ExamCollection.class, id);
		this.em.detach(examCollection);
		
		final Optional<ExamCollection> examCollectionOptional = Optional.ofNullable(examCollection);
		
		return examCollectionOptional;
	}

	@Override
	public List<ExamCollection> getAll(final Long studentId, final Long classId) {
		final String sql = 
				" SELECT tec "
				+ "FROM ExamCollection tec "
				+ "INNER JOIN FETCH tec.examSchedule tes "
				+ "INNER JOIN FETCH tes.exam te "
				+ "INNER JOIN FETCH te.classroom tc "
				+ "WHERE tec.createdBy = :studentId "
				+ "AND tc.id = :classId "
				+ "ORDER BY tec.id ASC";
		
		final List<ExamCollection> examCollections = this.em.createQuery(sql, ExamCollection.class)
				.setParameter("studentId", studentId)
				.setParameter("classId", classId)
				.getResultList();
		return examCollections;	
	}
	
	@Override
	public List<ExamCollection> getAllStudent(final Long teacherId, final Long classId) {
		final String sql = 
				" SELECT tec  "
				+ "FROM ExamCollection tec "
				+ "INNER JOIN FETCH tec.examSchedule tes "
				+ "INNER JOIN FETCH tes.exam te "
				+ "INNER JOIN FETCH te.classroom tc "
				+ "INNER JOIN FETCH tc.teacher tch "
				+ "WHERE tch.id = :teacherId AND tec.isActive = true "
				+ "AND tc.id = :classId "
				+ "ORDER BY tec.id ASC";		
		final List<ExamCollection> examCollections = this.em.createQuery(sql, ExamCollection.class)
				.setParameter("teacherId", teacherId)
				.setParameter("classId", classId)
				.getResultList();
		return examCollections;	
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ExamCollection WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
