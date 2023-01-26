package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.MaterialScheduleDao;
import com.lawencon.elearning.model.MaterialSchedule;

@Repository
public class MaterialScheduleDaoImpl extends BaseDaoImpl implements MaterialScheduleDao {

	
	@Override
	public MaterialSchedule insert(final MaterialSchedule data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public MaterialSchedule update(final MaterialSchedule data) {
		final MaterialSchedule materialScheduleUpdated = this.em.merge(data);
		this.em.flush();

		return materialScheduleUpdated;
	}

	@Override
	public Optional<MaterialSchedule> getById(final Long id) {
		final MaterialSchedule materialSchedule = this.em.find(MaterialSchedule.class, id);
		this.em.detach(materialSchedule);
		
		final Optional<MaterialSchedule> materialScheduleOptional = Optional.ofNullable(materialSchedule);
		
		return materialScheduleOptional;
	}

	@Override
	public List<MaterialSchedule> getAll(final Long studentId, final Long classId) {
		final String sql = 
				" SELECT tms FROM MaterialSchedule tms "
				+ "INNER JOIN FETCH tms.material tm "
				+ "INNER JOIN FETCH tm.classroom tc "
				+ "INNER JOIN FETCH tc.teacher teacher "
				+ "INNER JOIN FETCH ClassroomDetail tcd "
				+ "ON tc = tcd.classroom "
				+ "INNER JOIN tcd.student student "
				+ "WHERE student.id = :studentId AND tc.id = :classId " 
				+ "ORDER BY tms.id ASC";
		
		final List<MaterialSchedule> materialSchedules = this.em.createQuery(sql, MaterialSchedule.class)
				.setParameter("studentId", studentId)
				.setParameter("classId", classId)
				.getResultList();
		return materialSchedules;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM MaterialSchedule WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
