package com.mbd.base;

import java.util.List;

/**
 * Base Persistent Object
 * 
 * @param <IDType>
 *            - Identifier type
 * @param <VO>
 *            - Value object type
 * @param <DAO>
 *            - DAO type
 */
public abstract class PersistentBO<IDType extends Object, VO extends HibernateVO<IDType>, DAO extends HibernateDAO<IDType, VO>> {

	/** Value object */
	private VO vo;

	/** default */
	public PersistentBO() {
		super();
	}

	/**
	 * @param vo
	 *            - Value object
	 */
	public PersistentBO(VO vo) {
		super();
		this.vo = vo;
	}

	/**
	 * Returns full list of the stored objects
	 * 
	 * @return List
	 */
	public List<VO> fetchAll() {
		List<VO> all = getDAO().fetchAll();
		return all;
	}

	/**
	 * @return DAO
	 */
	public abstract DAO getDAO();

	/**
	 * Stores given value object
	 */
	public void save() {
		getDAO().save(getVo());
	}

	protected VO getVo() {
		return this.vo;
	}

}
