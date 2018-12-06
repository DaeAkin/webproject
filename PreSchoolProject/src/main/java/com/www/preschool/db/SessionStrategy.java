package com.www.preschool.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface SessionStrategy<T> {
	public T doWithSession(Session session);

}
