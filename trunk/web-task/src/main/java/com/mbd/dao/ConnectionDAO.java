package com.mbd.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mbd.base.HibernateDAO;
import com.mbd.model.ConnectionVO;
import com.mbd.util.Utils;

/**
 * Connection DAO object
 */
@Repository
public class ConnectionDAO extends HibernateDAO<Integer, ConnectionVO> {

	/**
	 * Retrieves connections by given date range
	 * 
	 * @param from
	 *            - start date
	 * @param to
	 *            - end date
	 * @return List - result list
	 */
	@Transactional
	public List<ConnectionVO> fetchInRange(Date from, Date to) {

		StringBuilder sql = new StringBuilder();
		sql.append("FROM ConnectionVO ");

		if (from != null || to != null) {
			sql.append("WHERE ");

			if (from != null) {
				sql.append("time >= :from ");
			}

			if (from != null && to != null) {
				sql.append("AND ");
			}

			if (to != null) {
				sql.append("time < :to ");
			}
		}

		TypedQuery<ConnectionVO> query = getEntityManager().createQuery(
				sql.toString(), ConnectionVO.class);

		if (from != null) {
			query.setParameter("from", from);
		}

		if (to != null) {
			query.setParameter("to", Utils.nextDayStart(to));
		}

		return query.getResultList();

	}

	/**
	 * @see com.mbd.base.HibernateDAO#getVOClazz()
	 */
	@Override
	protected Class<ConnectionVO> getVOClazz() {
		return ConnectionVO.class;
	}

}
