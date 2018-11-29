package com.www.preschool.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbOperations {
	private static SessionFactory factory; 
	
    try {
        factory = new Configuration().configure().buildSessionFactory();
     } catch (Throwable ex) { 
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex); 
     }

}
