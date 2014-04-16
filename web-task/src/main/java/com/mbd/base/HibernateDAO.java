package com.mbd.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

/**
 * Base DAO Object
 * 
 * @param <IDType>
 *            - Identifier Type
 * @param <VO>
 *            - Value Object
 */
public abstract class HibernateDAO<IDType extends Object, VO extends HibernateVO<IDType>> {

	@PersistenceContext
	private EntityManager entityManager;

	/** */
	public HibernateDAO() {
		super();
	}

	/**
	 * Retrieves all connections stored in the database
	 * 
	 * @return List - result list
	 */
	@Transactional
	public List<VO> fetchAll() {

		TypedQuery<VO> query = getEntityManager().createQuery(
				"FROM " + getVOClazz().getName(), getVOClazz());

		return query.getResultList();
	}

	/**
	 * Saves given Value Object
	 * 
	 * @param vo
	 * @return IDType
	 */
	@Transactional
	public IDType save(VO vo) {

		getEntityManager().persist(vo);

		return vo.getId();
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * Returns current VO Class
	 * 
	 * @return Class
	 */
	protected abstract Class<VO> getVOClazz();
}
