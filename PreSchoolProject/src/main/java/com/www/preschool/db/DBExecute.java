package com.www.preschool.db;

import org.hibernate.Session;

import com.www.preschool.dto.PortfolioDto;

public class DBExecute {
	
	DBTemplate dbTemplate = new DBTemplate();
	
	public <T> Integer addExecute(final T t) {
		return dbTemplate.execute(new SessionStrategy<Integer>() {

			@Override
			public Integer doWithSession(Session session) {
				// TODO Auto-generated method stub
				return (Integer) session.save(t);
				
			}
		});
	}
	
	
	public <T> void deleteAllContent(final String query) {
		dbTemplate.execute(new SessionStrategy<T>() {

			@Override
			public T doWithSession(Session session) {
				// TODO Auto-generated method stub
				session.createNativeQuery(query).executeUpdate();
				return null;
			}
			
		});
	}
	
	
	public <T> void update(final T t) {
		dbTemplate.execute(new SessionStrategy<T>() {

			@Override
			public T doWithSession(Session session) {
				// TODO Auto-generated method stub
				session.update(t);
				return null;
			}
			
		});
		
		
	}
	
	public <T> T getOne(final int UNIQUE_NO , final Class<T> returnClass) {
		return dbTemplate.execute(new SessionStrategy<T>() {

			@Override
			public T doWithSession(Session session) {
				// TODO Auto-generated method stub
				return (T) session.get(returnClass, UNIQUE_NO);
			}
			
		});
	}

}
