package com.mbd.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Context Initializer
 */
public class ContextInitializer {

	private static ClassPathXmlApplicationContext ctx = null;

	private static final String CTX_CONFIG = "applicationContext.xml";

	private static ContextInitializer instance = null;

	public static ContextInitializer getInstance() {
		if (instance == null) {
			instance = new ContextInitializer();
		}
		return instance;
	}

	public ContextInitializer() {
		super();
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext(CTX_CONFIG);
		}
	}

	public void destroy() {
		if (ctx != null && ctx.isActive()) {
			ctx.close();
		}
	}

	public <T> T getBean(Class<T> beanClz, String name) {
		return beanClz.cast(getCtx().getBean(name));
	}

	public ClassPathXmlApplicationContext getCtx() {
		return ctx;
	}

}
