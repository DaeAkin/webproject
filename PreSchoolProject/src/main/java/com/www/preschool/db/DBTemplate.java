package com.www.preschool.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.www.preschool.dto.PortfolioDto;

public class DBTemplate implements SessionCallback{
	private SessionFactory factory;
	
	
	public static String xmlLocation = "hibernate.cfg.xml";
	
	public static void setXmlLocation(String xmlLocation) {
		DBTemplate.xmlLocation = xmlLocation;
	}
	

	
	private SessionFactory buildSessionFacotry() {
    	
	       try {
	            factory = new Configuration().
	            		configure(xmlLocation).
	            		addAnnotatedClass(PortfolioDto.class).
	            		buildSessionFactory();
	           
	         } catch (Throwable ex) { 
	            System.err.println("Failed to create sessionFactory object." + ex);
	            throw new ExceptionInInitializerError(ex); 
	         }
	       return factory;
		}
	

	@Override
	public <T> T execute(SessionStrategy<T> ssst) {
		
		buildSessionFacotry();
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			T t = ssst.doWithSession(session);
			tx.commit();
			return t;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
