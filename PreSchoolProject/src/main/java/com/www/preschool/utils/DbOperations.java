package com.www.preschool.utils;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.www.preschool.dto.PortofolioDto;

public class DbOperations {
	private static SessionFactory factory; 

   
    	
       static { try {
            factory = new Configuration().configure().buildSessionFactory();
           
         } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
       }
    
    
    /* 데이터베이스에 Portofolio 추가하는 메소드 */
    public Integer addPortofolio(PortofolioDto portfolio){
    	
    	
       Session session = factory.openSession();
       Transaction tx = null;
       Integer portofolioID = null;
       
       try {
          tx = session.beginTransaction();
          portofolioID = (Integer) session.save(portfolio); 
          tx.commit();
       } catch (HibernateException e) {
          if (tx!=null) tx.rollback();
          e.printStackTrace(); 
       } finally {
          session.close(); 
       }
       return portofolioID;
    }
    
    


}
 