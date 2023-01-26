package com.lawencon.elearning.dao.impl.hibernate.hql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDaoImpl {

	protected EntityManager em;
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
