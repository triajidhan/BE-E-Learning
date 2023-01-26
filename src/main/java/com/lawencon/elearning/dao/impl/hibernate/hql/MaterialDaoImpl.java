package com.lawencon.elearning.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.MaterialDao;
import com.lawencon.elearning.model.Material;

@Repository
public class MaterialDaoImpl extends BaseDaoImpl implements MaterialDao {

	
	@Override
	public Material insert(final Material data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Material update(final Material data) {
		final Material materialUpdated = this.em.merge(data);
		this.em.flush();

		return materialUpdated;
	}

	@Override
	public Optional<Material> getById(final Long id) {
		final Material material = this.em.find(Material.class, id);
		this.em.detach(material);
		
		final Optional<Material> materialOptional = Optional.ofNullable(material);
		
		return materialOptional;
	}

	@Override
	public List<Material> getAll() {
		final String sql = " SELECT m FROM Material m";

		final List<Material> materials = this.em.createQuery(sql, Material.class)
		.getResultList();
		return materials;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Material WHERE id = :id ";
		
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}
}
