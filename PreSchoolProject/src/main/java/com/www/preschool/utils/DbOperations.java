package com.www.preschool.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.www.preschool.dto.PortfolioDto;

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
    public Integer addPortofolio(PortfolioDto portfolio){
    
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
    
    // 포토폴리오의 모든 리스트를 가져오는 함수
    public List<PortfolioDto> getAllList( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List<PortfolioDto> portfolioDtos = null;
        
        try {
        	System.out.println(" 포토폴리오 모든 리스트 ");
           tx = session.beginTransaction();
           portfolioDtos = session.createQuery("FROM portfolio").list(); 

           tx.commit();
        } catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        } finally {
           session.close(); 
        }
        
        return portfolioDtos;
     }
    
//    public List<PortfolioDto> selectOne( ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        PortfolioDto portfolioDto = null;
//        
//        try {
//           tx = session.beginTransaction();
//           portfolioDto = session.
//
//           tx.commit();
//        } catch (HibernateException e) {
//           if (tx!=null) tx.rollback();
//           e.printStackTrace(); 
//        } finally {
//           session.close(); 
//        }
//        
//        return portfolioDtos;
//     }
    
    
    


}
 