package com.www.preschool.db;

public interface SessionCallback {
	<T> T execute(SessionStrategy<T> ssst);
}
