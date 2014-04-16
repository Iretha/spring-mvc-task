package com.mbd.base;

/**
 * Base Value Object
 * 
 * @param <T>
 *            - Idetifier Type
 */
public abstract class HibernateVO<T> {

	private T id;

	public T getId() {
		return this.id;
	}

}
