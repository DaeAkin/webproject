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
    
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
           tx = session.beginTransaction();
           List<PortfolioDto> = session.createQuery("FROM Porto").list(); 
           for (Iterator iterator = employees.iterator(); iterator.hasNext();){
              Employee employee = (Employee) iterator.next(); 
              System.out.print("First Name: " + employee.getFirstName()); 
              System.out.print("  Last Name: " + employee.getLastName()); 
              System.out.println("  Salary: " + employee.getSalary()); 
           }
           tx.commit();
        } catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        } finally {
           session.close(); 
        }
     }
    
    


}
 