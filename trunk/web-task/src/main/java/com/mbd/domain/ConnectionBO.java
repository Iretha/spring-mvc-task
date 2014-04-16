package com.mbd.domain;

import java.util.Date;
import java.util.List;

import com.mbd.base.ContextInitializer;
import com.mbd.base.PersistentBO;
import com.mbd.dao.ConnectionDAO;
import com.mbd.model.ConnectionVO;

/**
 * Connections object. This Connection object is responsible for specific
 * behavior of the Connection object if any.
 */
public class ConnectionBO extends
		PersistentBO<Integer, ConnectionVO, ConnectionDAO> {

	public ConnectionBO() {
		super();
	}

	public ConnectionBO(ConnectionVO vo) {
		super(vo);

	}

	public List<ConnectionVO> fetchAllInRange(Date from, Date to) {

		List<ConnectionVO> all = getDAO().fetchInRange(from, to);

		return all;
	}

	/**
	 * @see com.mbd.base.PersistentBO#getDAO()
	 */
	@Override
	public ConnectionDAO getDAO() {
		return ContextInitializer.getInstance().getBean(ConnectionDAO.class,
				"connectionDao");
	}
}
