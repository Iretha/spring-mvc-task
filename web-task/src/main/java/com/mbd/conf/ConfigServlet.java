package com.mbd.conf;

import javax.servlet.http.HttpServlet;

import com.mbd.base.ContextInitializer;

/**
 * Basic Config Servlet
 */
public class ConfigServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		ContextInitializer.getInstance().destroy();
		super.destroy();
	}

}
